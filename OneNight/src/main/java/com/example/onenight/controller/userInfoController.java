package com.example.onenight.controller;

import com.alibaba.fastjson.JSON;
import com.example.onenight.entity.MyChatUser;
import com.example.onenight.service.MyChatUserService;
import com.example.onenight.utils.RedisUtil;
import com.example.onenight.utils.Result;
import com.example.onenight.utils.ResultUtils;
import com.example.onenight.utils.myStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/userInfo")
public class userInfoController {
    @Autowired
    private myStringUtil stringUtil;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private MyChatUserService myChatUserService;


    @PostMapping("/loginUserInfo")
    @ResponseBody
    public Result findLoginUserInfo(HttpSession session){
        String loginUser=(String) session.getAttribute("LOGINUSER");
        if(!stringUtil.isNullorEmpty(loginUser)){
            String[] loginKeyArr=loginUser.split("@@");
            String md5Account=loginKeyArr[0];
            MyChatUser myChatUser=(MyChatUser)redisUtil.get("USERINFO_"+md5Account);
            if(myChatUser==null){
                myChatUser=(MyChatUser) myChatUserService.selectUserInfoByAccount(loginKeyArr[2]).getResult();
                redisUtil.set("USERINFO_"+md5Account,myChatUser,1800);
            }
            System.out.println("========"+ JSON.toJSONString(myChatUser));
            return ResultUtils.success("查询成功",myChatUser);
        }else {
            return ResultUtils.error("用户未登录或登录信息失效,请先登录");
        }

    }

    @PostMapping("/userInfoList")
    @ResponseBody
    public Result userInfoList(HttpSession session, HttpServletRequest request){
        String loginUser=(String) session.getAttribute("LOGINUSER");
        String searchKey=request.getParameter("searchKey");
        if(!stringUtil.isNullorEmpty(loginUser)) {
            if(!stringUtil.isNullorEmpty(searchKey)){
                return myChatUserService.selectNormalUserBySearchKey(loginUser,searchKey);
            }else {
                return myChatUserService.selectAllNormalUserInfo(loginUser);
            }
        }else {
            return ResultUtils.error("用户未登录或登录信息失效,请先登录");
        }

    }

}
