package com.example.onenight.controller;

import com.alibaba.fastjson.JSON;
import com.example.onenight.entity.MyChatUser;
import com.example.onenight.utils.myStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class toPageController {
    @Autowired
    private myStringUtil stringUtil;

    /**
     * 登录页
     */
    @RequestMapping("/login.html")
    public String toLoginPage(Model model){
        return "login/login.html";
    }

    /**
     * 注册页
     */
    @RequestMapping("/registered.html")
    public String toRegisterPage(Model model){
        return "login/registered.html";
    }

    /**
     * 主页
     */
    @RequestMapping("/index.html")
    public String toIndexPage(Model model, HttpSession session){
        /*ModelAndView view=new ModelAndView("index.html");
        view.addObject("loginKey",JSON.toJSONString(session.getAttribute("LOGINUSER")));
        return view;*/
        model.addAttribute("loginKey", session.getAttribute("LOGINUSER"));
        return "index.html";
    }

    /**
     * 聊天主页
     */
    @RequestMapping("/chatIndex.html")
    public String toChatIndexPage(Model model, HttpSession session){
        String loginUser=(String) session.getAttribute("LOGINUSER");
        if(!stringUtil.isNullorEmpty(loginUser)){
            model.addAttribute("loginKey", session.getAttribute("LOGINUSER"));
            return "chatindex.html";
        }else {
            return "login/login.html";
        }


    }


}
