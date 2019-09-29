package com.forezp.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.PropertySource;

/**
 * program arguments指定一下参数，使用特定的application.yml配置文件
 * --spring.profiles.active=peer1
 */
// @PropertySource("classpath:application-peer1.yml")该注解不能加载application文件，只能加载一般的属性配置文件
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}
