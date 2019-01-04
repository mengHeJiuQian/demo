package com.example.service;

import com.example.domain.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2018/12/13 11:13
 */
public interface PersonService {

    public List<Person> getAll();
    public Person getById(@Param("id") Integer id);


    public void insert(@Param("person") Person person);
}
