package com.example.onenight.controller;

import com.alibaba.fastjson.JSON;
import com.example.onenight.entity.LoginUser;
import com.example.onenight.entity.User;
import com.example.onenight.service.LoginService;
import com.example.onenight.service.UserService;
import com.example.onenight.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/test")
public class testController {
    @Autowired
    UserService userService;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    myStringUtil stringUtil;

    @RequestMapping("/index")
    public String for_index(){
        return "index.html";
    }



    /**
     *@description:测试generator生成的sql是否能正常执行，测试MD5加密工具类
     *@author: ztx
     *
     */
    @RequestMapping("/testUtil")
    @ResponseBody
    public String testUtil(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("ss"));
        User user=userService.selectByPrimaryKey(id);
        System.out.println("================---"+user.toString());
        String md5= MD5Utils.str2MD5(request.getParameter("password"));
        md5.indexOf("1");
        System.out.println("原密码："+request.getParameter("password")+"----MD5:"+md5);
        return "success";
    }

    /**
     *@description:添加缓存数据
     *@author: ztx
     *
     */
    @RequestMapping("/redisSet")
    @ResponseBody
    public String set() {
        //redisUtil.set("test_506_user", "张天啸");
        User user=new User();
        user.setUserName("大傻");
        user.setPassword("1233");
        user.setUserPower("大会员");
        redisUtil.set("506_usersgroup2",user);
        return "success saved user !";
    }

    /**
     *@description:通过key获取缓存中的数据
     *@author: ztx
     *
     */
    @RequestMapping("/redisGet")
    @ResponseBody
    public String get() {
        //String user = (String) redisUtil.get("test_506_user");
        User user=(User)redisUtil.get("506_usersgroup2");
        return user.toString();
    }

    /**
     *@description:批量数据添加缓存
     *@author: ztx
     *
     */
    @RequestMapping("/redisSetList")
    @ResponseBody
    public String setList(){
        User user=new User();
        user.setUserName("敖丙");
        user.setPassword("1345445");
        user.setUserPower("小会员");
        User user2=new User();
        user2.setUserName("欧耶");
        user2.setUserPower("小会员");
        user2.setPassword("11");
        List<User> list=new ArrayList<>();
        list.add(user);
        list.add(user2);
        redisUtil.set("506_userGroup3", JSON.toJSONString(list));
        return "success";
    }

    /**
     *@description:测试二维码生成工具类
     *@author: ztx
     *
     */
    @RequestMapping("/testQRCodeUtil")
    @ResponseBody
    public void testQRCodeUtil()throws Exception{
        // 存放在二维码中的内容
        String text = "老铁，你投的简历有人回了吗？";
        // 嵌入二维码的图片路径
        String imgPath = "E:/picture/2.jpeg";
        // 生成的二维码的路径及名称
        String destPath = "E:/picture/qrCode1.jpg";
        //生成二维码
        QRCodeUtil.encode(text, imgPath, destPath, true);
        //生成字节流二维码
        byte[] bytes=QRCodeUtil.getQRCodeImage(text);
        // 解析二维码
        String str = QRCodeUtil.decode(destPath);
        // 打印出解析出的内容
        System.out.println(str);
        System.out.println("qrCodeByte:"+bytes.toString());



    }

    /**
     *@description:测试登录类的loginCode生成
     *@author: ztx
     *
     */
    @PostMapping("/testLoginCode")
    @ResponseBody
    public void testLoginCode(String userName){
        LoginUser loginUser=new LoginUser();
        loginUser.setLoginCode("111",userName);
        System.out.println("=======LoginCode:"+loginUser.getLoginCode());
    }

    /**
     *@description:测试session持久化到redis
     *@author: ztx
     *
     */
    @PostMapping("/testSessionToRedis")
    @ResponseBody
    public void testSessionToRedis(HttpSession  session){
        /*session.setAttribute("I,m_a_session23","我被持久化到这儿了");
        session.removeAttribute("I,m_a_session");
        String ss=(String) session.getAttribute("I,m_a_session");
        System.out.println("获取之前被持久化的session:"+ss);
        */
        String ss2=(String) session.getAttribute("LOGINUSER");

        System.out.println("这是我的loginCode:"+ss2);
        User user=(User) redisUtil.get(ss2);
        System.out.println("这是用户信息"+user.toString());

    }

    /**
     *@description:测试登录用户查询
     *@author: ztx
     *
     */
    @Autowired
    private LoginService loginService;

    @PostMapping("/testLoginSearch")
    @ResponseBody
    public Result testLoginSearch(HttpSession session,HttpServletRequest request){
      //return loginService.doLogin(session,request.getParameter("loginkey"),request.getParameter("password"));
        String a="1";
        String b="1";
        String d=new String("1");
        boolean c=(a==b);

        return ResultUtils.success("",c);
    }



    @PostMapping("/sendMail")
    @ResponseBody
    public Result testSendMail(){
      EMailUtil eMailUtil=new EMailUtil();
      Result result= eMailUtil.sendEmail("m13635576437@163.com","testMail","testMailContent");
      return  result;


    }


    @PostMapping("/testGetIP")
    @ResponseBody
    public Result getIp(HttpServletRequest request){
        String ip=stringUtil.getLocalIPForCMD();
        return ResultUtils.success("查询成功",ip);
    }


    @PostMapping("/testGetHourStr")
    @ResponseBody
    public Result getHourStr(HttpServletRequest request){
        String dateTime=request.getParameter("dateTime");
        String timeStr=stringUtil.dateTimeToHourStr(dateTime);
        return ResultUtils.success("查询成功",timeStr);
    }

}
