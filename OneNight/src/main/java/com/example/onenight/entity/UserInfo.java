package com.example.onenight.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.userinfo_id
     *
     * @mbggenerated
     */
    private Integer userinfoId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.user_name
     *
     * @mbggenerated
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.user_sex
     *
     * @mbggenerated
     */
    private Integer userSex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.user_age
     *
     * @mbggenerated
     */
    private Integer userAge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.user_birthday
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date userBirthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.head_picture
     *
     * @mbggenerated
     */
    private Integer headPicture;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.personal_signature
     *
     * @mbggenerated
     */
    private String personalSignature;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.user_city
     *
     * @mbggenerated
     */
    private String userCity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.user_qq
     *
     * @mbggenerated
     */
    private String userQq;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.user_wechat
     *
     * @mbggenerated
     */
    private String userWechat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.userinfo_id
     *
     * @return the value of userinfo.userinfo_id
     *
     * @mbggenerated
     */
    public Integer getUserinfoId() {
        return userinfoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.userinfo_id
     *
     * @param userinfoId the value for userinfo.userinfo_id
     *
     * @mbggenerated
     */
    public void setUserinfoId(Integer userinfoId) {
        this.userinfoId = userinfoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.user_id
     *
     * @return the value of userinfo.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.user_id
     *
     * @param userId the value for userinfo.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.user_name
     *
     * @return the value of userinfo.user_name
     *
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.user_name
     *
     * @param userName the value for userinfo.user_name
     *
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.user_sex
     *
     * @return the value of userinfo.user_sex
     *
     * @mbggenerated
     */
    public Integer getUserSex() {
        return userSex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.user_sex
     *
     * @param userSex the value for userinfo.user_sex
     *
     * @mbggenerated
     */
    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.user_age
     *
     * @return the value of userinfo.user_age
     *
     * @mbggenerated
     */
    public Integer getUserAge() {
        return userAge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.user_age
     *
     * @param userAge the value for userinfo.user_age
     *
     * @mbggenerated
     */
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.user_birthday
     *
     * @return the value of userinfo.user_birthday
     *
     * @mbggenerated
     */
    public Date getUserBirthday() {
        return userBirthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.user_birthday
     *
     * @param userBirthday the value for userinfo.user_birthday
     *
     * @mbggenerated
     */
    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.head_picture
     *
     * @return the value of userinfo.head_picture
     *
     * @mbggenerated
     */
    public Integer getHeadPicture() {
        return headPicture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.head_picture
     *
     * @param headPicture the value for userinfo.head_picture
     *
     * @mbggenerated
     */
    public void setHeadPicture(Integer headPicture) {
        this.headPicture = headPicture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.personal_signature
     *
     * @return the value of userinfo.personal_signature
     *
     * @mbggenerated
     */
    public String getPersonalSignature() {
        return personalSignature;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.personal_signature
     *
     * @param personalSignature the value for userinfo.personal_signature
     *
     * @mbggenerated
     */
    public void setPersonalSignature(String personalSignature) {
        this.personalSignature = personalSignature == null ? null : personalSignature.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.user_city
     *
     * @return the value of userinfo.user_city
     *
     * @mbggenerated
     */
    public String getUserCity() {
        return userCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.user_city
     *
     * @param userCity the value for userinfo.user_city
     *
     * @mbggenerated
     */
    public void setUserCity(String userCity) {
        this.userCity = userCity == null ? null : userCity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.user_qq
     *
     * @return the value of userinfo.user_qq
     *
     * @mbggenerated
     */
    public String getUserQq() {
        return userQq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.user_qq
     *
     * @param userQq the value for userinfo.user_qq
     *
     * @mbggenerated
     */
    public void setUserQq(String userQq) {
        this.userQq = userQq == null ? null : userQq.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.user_wechat
     *
     * @return the value of userinfo.user_wechat
     *
     * @mbggenerated
     */
    public String getUserWechat() {
        return userWechat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.user_wechat
     *
     * @param userWechat the value for userinfo.user_wechat
     *
     * @mbggenerated
     */
    public void setUserWechat(String userWechat) {
        this.userWechat = userWechat == null ? null : userWechat.trim();
    }
}