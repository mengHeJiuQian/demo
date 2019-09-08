package com.example.service;

import com.example.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2018/12/13 11:13
 */
public interface UserService {

    public List<User> getAll();
    public User getById(@Param("id") Long id);
    public void insert(@Param("user") User user);
}
