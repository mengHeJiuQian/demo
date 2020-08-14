package com.atguigu.bean;

import org.springframework.stereotype.Component;

/**
 * @author yang.liu
 * @createtime 2020/8/9 22:04
 * @description
 */
@Component
public class Car {

    public Car() {
        System.out.println("car constructor...");
    }

    public void init() {
        System.out.println("car init...");
    }

    public void destroy() {
        System.out.println("car destroy...");
    }

}
