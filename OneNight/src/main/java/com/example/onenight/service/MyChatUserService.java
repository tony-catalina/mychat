package com.example.onenight.service;

import com.example.onenight.entity.MyChatUser;
import com.example.onenight.utils.Result;

public interface MyChatUserService {
    /**
     * @Annotate:新增数据，可根据上传参数动态生成sql
     * @author ztx
     * @date 2020/6/4
     */
    Result doRegisterAccount(String account, String password);

    Result selectUserByAccount(String account);

    Result selectUserInfoByAccount(String account);

    /**
     * @Annotate:查询用户状态正常的非登录用户
     * @author ztx
     * @date 2020/6/12
     */
    Result selectAllNormalUserInfo(String loginUser);

    /**
     * @Annotate:根据用户输入的关键字进行模糊查询用户状态正常的非登录用户
     * @author ztx
     * @date 2020/6/15
     */
    Result selectNormalUserBySearchKey(String loginUser,String searchKey);
}
