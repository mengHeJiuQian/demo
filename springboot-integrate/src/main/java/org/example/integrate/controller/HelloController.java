package org.example.integrate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: sheldon
 * @Date: 2020/7/18 下午9:08
 * @Version: 1.0
 * Description:
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(String name) {
        return "hello " + name;
    }

}
