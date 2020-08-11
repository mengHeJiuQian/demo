package com.atguigu.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author yang.liu
 */
public class Person {

    @Value("张三")
    private String name;
    @Value("#{20 + 5}")
    private Integer age;
    @Value("${person.nickName}")
    private String nickName;

    public Person() { }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
