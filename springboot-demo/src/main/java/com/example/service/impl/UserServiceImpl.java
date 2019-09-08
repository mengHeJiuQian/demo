package com.example.service.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2018/12/13 11:14
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public User getById(Long id) {
        return userMapper.getById(id);
    }

    @Override
    public void insert(User user) {

    }
}
