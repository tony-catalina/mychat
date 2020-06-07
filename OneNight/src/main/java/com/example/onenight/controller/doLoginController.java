package com.example.onenight.controller;

import com.example.onenight.entity.MyChatUser;
import com.example.onenight.service.LoginService;
import com.example.onenight.service.MyChatUserService;
import com.example.onenight.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * Demo class
 *
 * @author ztx
 * @date 2020/4/29
 */

@Controller
@RequestMapping("/doLogin")
public class doLoginController {
    @Autowired
    private myStringUtil stringUtil;

    @Autowired
    private LoginService loginService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private MyChatUserService myChatUserService;

    /**
     * @Annotate:登录
     * @author ztx
     * @date 2020/6/3
     */
    @PostMapping("/login")
    @ResponseBody
    public Result doLogin(HttpServletRequest request){
        String loginKey=request.getParameter("loginkeys");
        String passWord=request.getParameter("passwords");
        if (stringUtil.isNullorEmpty(loginKey)){
            return ResultUtils.error("请保证输入账号不为空或空字符串");
        }
        if (stringUtil.isNullorEmpty(passWord)){
            return ResultUtils.error("请保证输入密码不为空");
        }

        Result result=loginService.doLogin(request.getSession(),loginKey,passWord);

        return result;


    }

    /**
     * @Annotate:注册
     * @author ztx
     * @date 2020/6/3
     */
    @PostMapping("/register")
    @ResponseBody
    public Result doRegister(HttpServletRequest request,String step){
        /*
        * step:步骤；1.获取验证码，2.确认验证码，3.注册账户
        * */
        String eMail=request.getParameter("registerKey");
        if(!stringUtil.isNullorEmpty(eMail)){
            if("1".equals(step)){
               Result isRegister= myChatUserService.selectUserByAccount(eMail);
               if(isRegister.getCode()==0){
                   return getCaptcha(eMail);
               }else {
                   return ResultUtils.error("该账户已注册,请直接登录");
               }

            }else if("2".equals(step)){
                String Captcha=(String)redisUtil.get("CAPTCHA"+eMail);
                if(!stringUtil.isNull(Captcha)){
                    return ResultUtils.success("查询成功",Captcha);
                }else {
                    return ResultUtils.error("验证码已过期");
                }

            }else if("3".equals(step)){
                String password=request.getParameter("registerPwd");
                return myChatUserService.doRegisterAccount(eMail,password);
            }else {
                return ResultUtils.error("请求不合法");
            }
        }else {
            return ResultUtils.error("请确保注册邮箱不为空");
        }


    }


    /**
     * @Annotate:忘记密码，发送临时登录码
     * @author ztx
     * @date 2020/6/3
     */
    @PostMapping("/forgetPwd")
    @ResponseBody
    public Result forgetPwd(HttpServletRequest request){
        String eMail=request.getParameter("eMailAccount");
        if(!stringUtil.isNullorEmpty(eMail)){
            Result isRegister= myChatUserService.selectUserByAccount(eMail);
            if(isRegister.getCode()==0){
                return ResultUtils.error("该账户还未注册,请注册账号");
            }else {
                return loginForOnce(eMail);
            }
        }else {
            return ResultUtils.error("请保证登录账号不为空");
        }

    }


    /**
     * @Annotate:获取注册验证码
     * @author ztx
     * @date 2020/6/3
     * -----想法：这个功能设计思路，我现在想做一个邮箱发送验证码，用户获取到验证码验证的功能，但是这个验
     * 证码应该有过期时间，我直接返回到前台js验证的话，就算那个人过了时间在输入还是一样可以，而且也不安全，现在
     * 我准备将数据添加到redis里面，做一个缓存，设置数据的过期时间，在这个人填写完验证码之后再发一个请求查询缓
     * 存中的验证码，如果查不到就是数据过期了，在过期时间内查询验证。同一时间内不会有其他人登录同一个邮箱，所以
     * 不担心邮箱问题
     */
    private Result getCaptcha(String eMail){
        EMailUtil eMailUtil=new EMailUtil();
        String captcha=stringUtil.getRandomFourNum();
        redisUtil.set("CAPTCHA"+eMail,captcha,90);
        Result result=eMailUtil.sendEmail(eMail,"注册验证码","您本次注册请求的验证码为:"+captcha);
        if(result.getCode()==0){
            return ResultUtils.success("请求成功",captcha);
        }else {
            return ResultUtils.error("请求失败");
        }
        //return ResultUtils.success("成功",captcha);
    }



    private Result loginForOnce(String eMail){
        EMailUtil eMailUtil=new EMailUtil();
        String onceLoginCode=stringUtil.getRandomSixNum();
        redisUtil.set("ONCELOGIN"+eMail,onceLoginCode,60);
        Result result=eMailUtil.sendEmail(eMail,"临时登录码","您本次登录的临时密码为:"+onceLoginCode);
        if(result.getCode()==0){
            return ResultUtils.success("临时登录码已发送到邮箱,请注意接收",onceLoginCode);
        }else {
            return ResultUtils.error("请求失败");
        }
        //return ResultUtils.success("成功",captcha);
    }





}
