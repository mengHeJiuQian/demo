package org.springboot.shiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description 毕业设计需要一个登录的操作，打算使用shiro框架
 * @Author yang.liu
 * @Date 2018/12/17 12:30
 */
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
//@PropertySource(value = {"classpath:com/shiro/application.properties"})
//@Configuration
@SpringBootApplication
public class ShiroDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroDemoApplication.class, args);
    }

}
