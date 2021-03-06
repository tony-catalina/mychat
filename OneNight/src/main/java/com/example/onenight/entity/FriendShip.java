package com.example.onenight.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FriendShip {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friendship.friendship_id
     *
     * @mbggenerated
     */
    private Integer friendshipId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friendship.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friendship.friend_id
     *
     * @mbggenerated
     */
    private Integer friendId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friendship.createtime
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friendship.friend_state
     *
     * @mbggenerated
     */
    private Integer friendState;


    private String friendName;

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friendship.friendship_id
     *
     * @return the value of friendship.friendship_id
     *
     * @mbggenerated
     */
    public Integer getFriendshipId() {
        return friendshipId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friendship.friendship_id
     *
     * @param friendshipId the value for friendship.friendship_id
     *
     * @mbggenerated
     */
    public void setFriendshipId(Integer friendshipId) {
        this.friendshipId = friendshipId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friendship.user_id
     *
     * @return the value of friendship.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friendship.user_id
     *
     * @param userId the value for friendship.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friendship.friend_id
     *
     * @return the value of friendship.friend_id
     *
     * @mbggenerated
     */
    public Integer getFriendId() {
        return friendId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friendship.friend_id
     *
     * @param friendId the value for friendship.friend_id
     *
     * @mbggenerated
     */
    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friendship.createtime
     *
     * @return the value of friendship.createtime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friendship.createtime
     *
     * @param createtime the value for friendship.createtime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friendship.friend_state
     *
     * @return the value of friendship.friend_state
     *
     * @mbggenerated
     */
    public Integer getFriendState() {
        return friendState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friendship.friend_state
     *
     * @param friendState the value for friendship.friend_state
     *
     * @mbggenerated
     */
    public void setFriendState(Integer friendState) {
        this.friendState = friendState;
    }
}