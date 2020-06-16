package com.example.onenight.service.impl;

import com.example.onenight.entity.FriendApply;
import com.example.onenight.mapper.FriendApplyMapper;
import com.example.onenight.service.FriendApplyService;
import com.example.onenight.utils.Result;
import com.example.onenight.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendApplyServiceImpl implements FriendApplyService {
    @Autowired
    FriendApplyMapper friendApplyMapper;

    @Override
    public Result addOneFriendApply(FriendApply friendApply) {
        int applyCount=friendApplyMapper.selectCountByUserId(friendApply.getApplyUserid(),friendApply.getFriendUserid());
        if(applyCount==0){
            int i=friendApplyMapper.insertSelective(friendApply);
            if(i==1){
                return ResultUtils.success("申请已添加成功",i);
            }else {
                return ResultUtils.error("好友申请添加失败");
            }
        }else {
            return ResultUtils.error("您已向该用户添加过好友申请，请不要重复添加");
        }

    }
}
