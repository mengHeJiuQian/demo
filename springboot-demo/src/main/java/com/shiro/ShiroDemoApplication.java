package com.shiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @Description 毕业设计需要一个登录的操作，打算使用shiro框架
 * @Author yang.liu
 * @Date 2018/12/17 12:30
 */
@PropertySource(value = {"classpath:com/shiro/application.properties"})
@SpringBootApplication
public class ShiroDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroDemoApplication.class, args);
    }

}
