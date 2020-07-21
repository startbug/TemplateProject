package com.ggs.service.impl;

import com.ggs.dao.UserMapper;
import com.ggs.domain.User;
import com.ggs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Starbug
 * @Date 2020/7/21 16:14
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }
}
