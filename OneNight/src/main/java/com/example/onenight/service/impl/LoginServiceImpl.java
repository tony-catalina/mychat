package com.example.onenight.service.impl;

import com.example.onenight.entity.LoginUser;
import com.example.onenight.entity.MyChatUser;
import com.example.onenight.entity.User;
import com.example.onenight.mapper.MyChatUserMapper;
import com.example.onenight.mapper.UserMapper;
import com.example.onenight.service.LoginService;
import com.example.onenight.utils.RedisUtil;
import com.example.onenight.utils.Result;
import com.example.onenight.utils.ResultUtils;
import com.example.onenight.utils.myStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.SQLSyntaxErrorException;

/**
 * Demo class
 *
 * @author ztx
 * @date 2020/4/2
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private myStringUtil stringUtil;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private MyChatUserMapper myChatUserMapper;
    @Override
    public Result<Object> doLogin(HttpSession session, String loginkey, String password) {
        try{
            MyChatUser user1= myChatUserMapper.selectForLogin(loginkey);
            System.out.println("用户信息：==="+user1.toString());
            if(password.equals(user1.getUserPassword())||password.equals(redisUtil.get("ONCELOGIN"+loginkey))){
                LoginUser loginUser=new LoginUser();
                loginUser.setLoginCode(user1.getUserAccount(),user1.getUserName());
                session.setAttribute("LOGINUSER",loginUser.getLoginCode());
                String md5Account=loginUser.getLoginCode().substring(0,loginUser.getLoginCode().indexOf("^^"));
                user1.setIsLogin(1);
                redisUtil.set("USERINFO_"+md5Account,user1,3600);
                return ResultUtils.success("登录成功",loginUser.getLoginCode());
            }else {
                return ResultUtils.error("密码不匹配");
            }

        }catch (NullPointerException e){
            /*如果是空指针异常则打印异常，并返回对应的提示语句*/
            e.printStackTrace();
            return ResultUtils.error("该账户不存在");
        }


    }

    @Override
    public int exitLogin() {
        return 0;
    }
}
