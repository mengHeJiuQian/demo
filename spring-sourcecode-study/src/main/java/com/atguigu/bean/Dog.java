package com.atguigu.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author yang.liu
 * @createtime 2020/8/9 22:40
 * @description
 */
@Component
public class Dog {
    public Dog() {
        System.out.println("dog constructor...");
    }

    @PostConstruct
    public void init() {
        System.out.println("dog PostConstruct...");
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("dog PreDestroy...");
    }

}
