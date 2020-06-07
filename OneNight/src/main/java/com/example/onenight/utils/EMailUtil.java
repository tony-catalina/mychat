package com.example.onenight.utils;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EMailUtil {
    //邮箱
    private static  String SEND_EMAIL="2265349391@qq.com";
    //授权码
    private static String PASS_CODE="fnszgziqnklfdjdd";


    /**
     *@description:邮件发送
     *@author: ztx
     * email:要发送邮箱号，title：邮件标题，content：邮件内容
     */
    public Result sendEmail(String email,String title,String content){

        // 1.创建一个程序与邮件服务器会话对象 Session
        Properties props = new Properties();
        // 连接协议
        props.setProperty("mail.transport.protocol", "SMTP");
        // 连接协议
        props.setProperty("mail.smtp.host", "smtp.qq.com");//smtp.qq.com
        // 连接协议
        props.setProperty("mail.smtp.port", "25");
        // 指定验证为true
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.timeout","1000");
        // 验证账号及密码，密码需要是第三方授权码
        Authenticator auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(SEND_EMAIL, PASS_CODE);
            }
        };
        Session session = Session.getInstance(props, auth);

        // 2.创建一个Message，它相当于是邮件内容
        MimeMessage message = new MimeMessage(session);
        try {
            //防止成为垃圾邮件，披上outlook的马甲
            message.addHeader("X-Mailer","Microsoft Outlook Express 6.00.2900.2869");
            // 设置发送者
            message.setFrom(new InternetAddress(SEND_EMAIL));
            // 设置发送方式与接收者
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email));
            // 设置主题
            message.setSubject(title);

            //创建消息主体
            MimeBodyPart messageBodyPart = new MimeBodyPart();


            messageBodyPart.setText(content);

            // 创建多重消息
            Multipart multipart=new MimeMultipart();

            multipart.addBodyPart(messageBodyPart);

            // 设置邮件消息发送的时间
            message.setSentDate(Calendar.getInstance().getTime());
            // 设置内容
            message.setContent(multipart, "text/html;charset=utf-8");

            // 3.创建 Transport用于将邮件发送
            Transport.send(message);

            //处理发送邮件内容返回
            Map map=new HashMap();
            map.put("email",email);
            map.put("title",title);
            map.put("content",content);
            return ResultUtils.success("发送成功",map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtils.error(400,"发送失败");
        }
    }
}
