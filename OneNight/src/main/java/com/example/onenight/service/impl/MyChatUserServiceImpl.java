package com.example.onenight.service.impl;

import com.example.onenight.entity.MyChatUser;
import com.example.onenight.entity.UserInfo;
import com.example.onenight.mapper.MyChatUserMapper;
import com.example.onenight.mapper.UserInfoMapper;
import com.example.onenight.service.MyChatUserService;
import com.example.onenight.utils.Result;
import com.example.onenight.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MyChatUserServiceImpl implements MyChatUserService {
    @Autowired
    private MyChatUserMapper myChatUserMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Result doRegisterAccount(String account, String password) {
        MyChatUser myChatUser=new MyChatUser();
        myChatUser.setUserId(0);
        myChatUser.setUserAccount(account);
        myChatUser.setUserPassword(password);
        myChatUser.setCreatetime(new Date());
        myChatUser.setUserState(1);
        int state=0;
        state=myChatUserMapper.insertSelective(myChatUser);
        if(state==1){
            UserInfo userInfo=new UserInfo();
            userInfo.setUserId(myChatUser.getUserId());
            state=userInfoMapper.insertSelective(userInfo);
        }
        if(state==1){
            return ResultUtils.success("用户注册成功",myChatUser.getUserId());
        }else {
            return ResultUtils.error("用户创建失败");
        }

    }

    @Override
    public Result selectUserByAccount(String account) {
        int num=0;
        num=myChatUserMapper.selectUserByAccount(account);
        if(num>0){
            return ResultUtils.error("该账号已存在");
        }else {
            return ResultUtils.success("该账号可以注册",num);
        }

    }
}
