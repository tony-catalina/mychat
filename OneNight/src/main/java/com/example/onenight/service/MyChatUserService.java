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
}
