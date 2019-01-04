package com.example.mapper.test1;

import com.example.domain.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2018/12/13 10:58
 */
public interface PersonMapper {

    List<Person> getAll();

    Person getById(@Param("id") Integer id);


    void insert(@Param("person") Person person);

}
