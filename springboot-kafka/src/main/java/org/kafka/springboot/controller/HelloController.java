package org.kafka.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 内容描述：
 * 创建人：yang.liu
 * 创建时间：2019/7/11 11:00
 * 版本：1.0
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping(value = "/sayHello")
    public String sayHello(String name) {
        return "hello " + name;
    }

}
