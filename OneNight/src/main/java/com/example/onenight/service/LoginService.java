package com.example.onenight.service;

import com.example.onenight.entity.User;
import com.example.onenight.utils.Result;

import javax.servlet.http.HttpSession;

public interface LoginService {

    /**
     * fetch data by rule id
     *
     * @param ruleId rule id
     * @param page page number
     * @param jsonContext json format context
     * @return Result<XxxxDO>
     */
    Result doLogin(HttpSession session, String loginKey, String password);

    int exitLogin();
}
