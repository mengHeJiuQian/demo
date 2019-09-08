package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/1/4 17:32
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users = userService.getAll();
        return users;
    }

    @GetMapping("/getUser")
    public User getUser(Long id) {
        User user=userService.getById(id);
        return user;
    }
//
//    @RequestMapping("/add")
//    public void save(UserEntity user) {
//        user2Mapper.insert(user);
//    }
//
//    @RequestMapping(value="update")
//    public void update(UserEntity user) {
//        user2Mapper.update(user);
//    }
//
//    @RequestMapping(value="/delete/{id}")
//    public void delete(@PathVariable("id") Long id) {
//        user1Mapper.delete(id);
//    }

}
