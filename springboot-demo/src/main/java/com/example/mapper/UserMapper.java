package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2018/12/13 10:58
 */
public interface UserMapper {

    List<User> getAll();
    User getById(@Param("id") Long id);
    void insert(@Param("user") User user);

}
