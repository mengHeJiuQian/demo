package com.example.controller;

import com.example.config.NeoProperties;
import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2018/12/10 13:08
 */
@RestController
public class HelloWorldController {

    @Autowired
    private NeoProperties neoProperties;

    @RequestMapping("/hello")
    public String hello() {
        return "hello,xi-hong-shi-shou-fu";
    }

    @RequestMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setUsername("yang.liu");
        user.setPassword("123456");
        System.out.println(neoProperties.toString());
        return user;
    }

}
