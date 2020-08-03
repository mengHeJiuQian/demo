package com.example.controller;

import com.example.entity.Champion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建人：yang.liu
 * 创建时间：2020/7/15 22:38
 * 版本：1.0
 * 内容描述：
 */
@Slf4j
@RestController
public class HelloController {

    /**
     * 测试两个类同名不同类型，注入会报对象名重复而无法创建Spring容器
     */
    @Autowired
    private Champion champion;

    @GetMapping("/hello")
    public String hello(String name) {
        // web容器的加载器
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        log.info("contextClassLoader:{}", contextClassLoader);
        // 非web容器的加载器
        log.info("HelloController classloader:{}", HelloController.class.getClassLoader());
        return "hello " + name;
    }

}
