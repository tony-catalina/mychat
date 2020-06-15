package com.example.onenight.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Component
public class myStringUtil {

    //判断字符串是否为空或者空字符串
    public  boolean isNullorEmpty(String s){
        return s==null||"".equals(s);
    }

    //判单字符串是否为空
    public boolean isNull(String s){
        return s==null;
    }

    //判断字符串是否为空字符串
    public boolean isEmpty(String s){
        return "".equals(s);
    }

    //判断字符串是否为数字
    public boolean isNumeric(String s){
        for (int i=0;i<s.length();i++){
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    //判断一个字符串是否包含另一个字符串
    public boolean isContain(String s1,String s2){
        /*
         * indexOf(String s)的使用，如果包含，返回的值是包含该子字符串在父类字符串中起始位置；
         * 如果不包含必定全部返回值为-1
         * */
        if(s1.indexOf(s2)==-1){
            return false;
        }else {
            return true;
        }
    }

    //时间戳转String格式日期
    public String timeStampToDateOrDateTime(String s,String type){
        //请提前确认是时间戳，我这边默认时间戳正确，只分10位或13位。
        if(s.length()==10)
            s=s+"000";
        if("date".equals(type)){
            type = "yyyy-MM-dd";
        }else {
            //默认datetime类型
            type = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(type);
        return sdf.format(new Date(Long.valueOf(s)));
    }

    //时间戳转Date
    public Date timeStampToDate(String s){
        //请提前确认是时间戳，我这边默认时间戳正确，只分10位或13位。
        if(s.length()==10)
            s=s+"000";
        return new Date(Long.valueOf(s));
    }

    /**
     * @Annotate:验证码(生成四位随机数)
     * @author ztx
     * @date 2020/4/1
     */
    public String getRandomFourNum() {
        String[] beforeShuffle = new String[] { "2", "3", "4", "5", "6", "7",
                "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
                "W", "X", "Y", "Z" };
        List list = Arrays.asList(beforeShuffle);
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String afterShuffle = sb.toString();
        String result = afterShuffle.substring(5, 9);
        return result;
    }

    /**
     * @Annotate:验证码(生成六位随机数)
     * @author ztx
     * @date 2020/6/4
     */
    public String getRandomSixNum() {
        String[] beforeShuffle = new String[] { "2", "3", "4", "5", "6", "7",
                "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
                "W", "X", "Y", "Z" };
        List list = Arrays.asList(beforeShuffle);
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String afterShuffle = sb.toString();
        String result = afterShuffle.substring(5, 11);
        return result;
    }


    /**
     * @Annotate:获取有中间代理的发送请求设备ip(Apache,Squid)
     * @author ztx
     * @date 2020/6/11
     */
    public String getIp(HttpServletRequest request) {

        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 处理多IP的情况（只取第一个IP）
        if (ip != null && ip.contains(",")) {
            String[] ipArray = ip.split(",");
            ip = ipArray[0];
        }
        System.err.println(ip);
        return ip;
    }

    /**
     * @Annotate:正常获取发送请求设备ip
     * @author ztx
     * @date 2020/6/11
     */
    public String getIp2(HttpServletRequest request){

        String requestUrlIP = request.getServerName();
        String userIpAddr = request.getRemoteAddr();
        System.out.println("***访问的Url中的服务器IP："+requestUrlIP);
        System.out.println("***用户客户端的IP地址："+userIpAddr);
        return userIpAddr;
    }

    /**
     * @Annotate:通过cmd命令获取本机ip
     * @author ztx
     * @date 2020/6/12
     */
    public String getLocalIPForCMD() {
        StringBuilder sb = new StringBuilder();
        String command = "cmd.exe /c ipconfig | findstr IPv4"; 		// 管道命令
        try {
            Process p = Runtime.getRuntime().exec(command); 		// 执行命令
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream())); // 包装缓冲输入流
            String line = null;
            while((line = br.readLine()) != null){					//循环读取
                line = line.substring(line.lastIndexOf(":")+2,line.length()); //截取IPV4地址
                sb.append(line);
            }
            br.close();  					// 字符流关闭
            p.destroy(); 					// 进程销毁
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString(); 				// 返回IPV4地址
    }




}
