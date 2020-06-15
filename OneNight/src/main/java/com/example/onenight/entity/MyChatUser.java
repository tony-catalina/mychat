package com.example.onenight.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MyChatUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.user_name
     *
     * @mbggenerated
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.user_account
     *
     * @mbggenerated
     */
    private String userAccount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.user_password
     *
     * @mbggenerated
     */
    private String userPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.is_login
     *
     * @mbggenerated
     */
    private Integer isLogin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.createtime
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.user_state
     *
     * @mbggenerated
     */
    private Integer userState;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.user_id
     *
     * @return the value of users.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.user_id
     *
     * @param userId the value for users.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.user_name
     *
     * @return the value of users.user_name
     *
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.user_name
     *
     * @param userName the value for users.user_name
     *
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.user_account
     *
     * @return the value of users.user_account
     *
     * @mbggenerated
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.user_account
     *
     * @param userAccount the value for users.user_account
     *
     * @mbggenerated
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.user_password
     *
     * @return the value of users.user_password
     *
     * @mbggenerated
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.user_password
     *
     * @param userPassword the value for users.user_password
     *
     * @mbggenerated
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.is_login
     *
     * @return the value of users.is_login
     *
     * @mbggenerated
     */
    public Integer getIsLogin() {
        return isLogin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.is_login
     *
     * @param isLogin the value for users.is_login
     *
     * @mbggenerated
     */
    public void setIsLogin(Integer isLogin) {
        this.isLogin = isLogin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.createtime
     *
     * @return the value of users.createtime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.createtime
     *
     * @param createtime the value for users.createtime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.user_state
     *
     * @return the value of users.user_state
     *
     * @mbggenerated
     */
    public Integer getUserState() {
        return userState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.user_state
     *
     * @param userState the value for users.user_state
     *
     * @mbggenerated
     */
    public void setUserState(Integer userState) {
        this.userState = userState;
    }
}