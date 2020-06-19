package com.example.onenight.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.onenight.entity.FriendApply;
import com.example.onenight.mapper.FriendApplyMapper;
import com.example.onenight.service.FriendApplyService;
import com.example.onenight.utils.Result;
import com.example.onenight.utils.ResultUtils;
import com.example.onenight.utils.myStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FriendApplyServiceImpl implements FriendApplyService {
    @Autowired
    FriendApplyMapper friendApplyMapper;

    @Autowired
    myStringUtil stringUtil;

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

    @Override
    public Result getFriendApplyByUserId(int userId,String searchKey) {
        List<Map<String,Object>> applyList=friendApplyMapper.getFriendApply(userId,searchKey);
        for(int i=0;i<applyList.size();i++){
            try{
                String applyTime=(String) applyList.get(i).get("apply_time");
                String apply_time=stringUtil.dateTimeToHourStr(applyTime);
                applyList.get(i).put("applyTimeStr",apply_time);
            }catch (Exception e){
                applyList.get(i).put("applyTimeStr","");
                e.printStackTrace();
            }
        }
        return ResultUtils.success("查询成功",applyList);
    }

    @Override
    public Result refuseFriendApply(int friendApplyId) {
        FriendApply friendApply=new FriendApply();
        friendApply.setFriendapplyId(friendApplyId);
        friendApply.setApplyState(3);
        int i=friendApplyMapper.updateByPrimaryKeySelective(friendApply);
        if(i==1){
            return ResultUtils.success("已拒绝该申请",i);
        }else {
            return ResultUtils.error("拒绝申请失败");
        }
    }
}
