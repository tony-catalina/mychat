package com.example.onenight.entity;

import java.util.Date;

public class FriendApply {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friendapply.friendapply_id
     *
     * @mbggenerated
     */
    private Integer friendapplyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friendapply.apply_userid
     *
     * @mbggenerated
     */
    private Integer applyUserid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friendapply.friend_userid
     *
     * @mbggenerated
     */
    private Integer friendUserid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friendapply.apply_time
     *
     * @mbggenerated
     */
    private Date applyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friendapply.apply_state
     *
     * @mbggenerated
     */
    private Integer applyState;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friendapply.friendapply_id
     *
     * @return the value of friendapply.friendapply_id
     *
     * @mbggenerated
     */
    public Integer getFriendapplyId() {
        return friendapplyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friendapply.friendapply_id
     *
     * @param friendapplyId the value for friendapply.friendapply_id
     *
     * @mbggenerated
     */
    public void setFriendapplyId(Integer friendapplyId) {
        this.friendapplyId = friendapplyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friendapply.apply_userid
     *
     * @return the value of friendapply.apply_userid
     *
     * @mbggenerated
     */
    public Integer getApplyUserid() {
        return applyUserid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friendapply.apply_userid
     *
     * @param applyUserid the value for friendapply.apply_userid
     *
     * @mbggenerated
     */
    public void setApplyUserid(Integer applyUserid) {
        this.applyUserid = applyUserid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friendapply.friend_userid
     *
     * @return the value of friendapply.friend_userid
     *
     * @mbggenerated
     */
    public Integer getFriendUserid() {
        return friendUserid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friendapply.friend_userid
     *
     * @param friendUserid the value for friendapply.friend_userid
     *
     * @mbggenerated
     */
    public void setFriendUserid(Integer friendUserid) {
        this.friendUserid = friendUserid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friendapply.apply_time
     *
     * @return the value of friendapply.apply_time
     *
     * @mbggenerated
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friendapply.apply_time
     *
     * @param applyTime the value for friendapply.apply_time
     *
     * @mbggenerated
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friendapply.apply_state
     *
     * @return the value of friendapply.apply_state
     *
     * @mbggenerated
     */
    public Integer getApplyState() {
        return applyState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friendapply.apply_state
     *
     * @param applyState the value for friendapply.apply_state
     *
     * @mbggenerated
     */
    public void setApplyState(Integer applyState) {
        this.applyState = applyState;
    }
}