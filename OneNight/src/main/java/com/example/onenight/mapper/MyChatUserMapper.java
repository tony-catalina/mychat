package com.example.onenight.mapper;

import com.example.onenight.entity.MyChatUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface MyChatUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    int insert(MyChatUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    int insertSelective(MyChatUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    MyChatUser selectByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MyChatUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MyChatUser record);

    MyChatUser selectForLogin(@Param("loginkey") String loginkey);

    int selectUserByAccount(@Param("account")String account);

    /**
     * @Annotate:isLogin:是否登录（1.是，2.否）  userState:用户状态(1.正常，2.注销，3.封停)
     * @author ztx
     * @date 2020/4/1
     */
    List<Map<String,Object>> selectAllUserInfo(@Param("isLogin")int isLogin, @Param("userState")int userState,@Param("loginUser")String loginUser);

    /**
     * @Annotate:默认查询用户状态正常的数据
     * @author ztx
     * @date 2020/4/1
     */
    List<Map<String,Object>> selectNormalUserBySearchKey(@Param("loginUser")String loginUser,@Param("searchKey")String searchKey);


    Map<String,Object> selectUserInfoById(@Param("userId")int userId);
}