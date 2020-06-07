package com.example.onenight.service.impl;

import com.example.onenight.entity.User;
import com.example.onenight.mapper.UserMapper;
import com.example.onenight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(int id) {

        return userMapper.selectByPrimaryKey(id);
    }
}
