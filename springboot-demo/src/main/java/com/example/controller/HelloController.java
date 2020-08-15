package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author: sheldon
 * @Date: 2020/1/9 下午5:13
 * @Version: 1.0
 * Description: 写一个用于访问的接口
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Object hello() {
        HashMap<String, String> map = new HashMap<>();
        map.put("sheldon", "hello springboot");
        int i = 1 / 0;
        return map;
    }

}
