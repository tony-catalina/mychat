package com.example.onenight.entity;

import com.example.onenight.utils.MD5Utils;

public class LoginUser {
    private String loginCode;
    private String passWord;

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode,String userName) {
        //暂时没有写自己的加密算法，这里借用MD5；
        StringBuffer encryptionStr= new StringBuffer(MD5Utils.str2MD5(loginCode));
        long timeStr=System.currentTimeMillis();
        encryptionStr.append("^^");
        encryptionStr.append(userName);
        encryptionStr.append("^^");
        encryptionStr.append(timeStr);
        this.loginCode = encryptionStr.toString();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
