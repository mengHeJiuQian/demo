package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2018/12/10 20:53
 */
@Data //注解在类上；提供类所有属性的 getting 和setting方法，此外还提供了equals、canEqual、hashCode、toString 方法
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    private Integer id;
    private String name;
    private String password;

    public Person(String name, String password) {
        this.name = name;
        this.password = password;
    }

}
