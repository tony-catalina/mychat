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
import java.util.List;
import java.util.Map;

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

    @Override
    public Result selectUserInfoByAccount(String account) {
        MyChatUser myChatUser=myChatUserMapper.selectForLogin(account);
        if(myChatUser!=null){
            return ResultUtils.success("查询成功",myChatUser);
        }else {
            return ResultUtils.error("查询失败,数据库中没有该人员信息,系统有被攻击风险");
        }

    }

    @Override
    public Result selectAllNormalUserInfo(String loginUser) {
        String[] loginKeyArr=loginUser.split("@@");
        List<Map<String,Object>> myChatUsers=myChatUserMapper.selectAllUserInfo(0,1,loginKeyArr[2]);
        return ResultUtils.success("查询成功",myChatUsers);
    }

    @Override
    public Result selectNormalUserBySearchKey(String loginUser, String searchKey) {
        String[] loginkeyArr=loginUser.split("@@");
        List<Map<String,Object>> maps=myChatUserMapper.selectNormalUserBySearchKey(loginkeyArr[2],searchKey);
        return ResultUtils.success("查询成功",maps);
    }

    @Override
    public Result selectUserInfoById(int id) {
        Map<String,Object> maps=myChatUserMapper.selectUserInfoById(id);
        return ResultUtils.success("查询成功",maps);
    }

}
