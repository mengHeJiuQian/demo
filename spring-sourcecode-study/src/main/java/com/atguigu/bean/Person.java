package com.atguigu.bean;

/**
 * @author yang.liu
 */
public class Person {

    private String name;
    private Integer age;

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
                '}';
    }
}
