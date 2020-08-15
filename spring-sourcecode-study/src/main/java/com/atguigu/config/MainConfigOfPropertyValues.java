package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author yang.liu
 * @createtime 2020/8/11 22:14
 * @description
 */
@PropertySource("classpath:/person.properties")
@Configuration
public class MainConfigOfPropertyValues {

    @Bean
    public Person person() {
        return new Person();
    }
}
