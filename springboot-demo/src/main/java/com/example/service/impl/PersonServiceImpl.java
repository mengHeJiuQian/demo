package com.example.service.impl;

import com.example.domain.Person;
import com.example.mapper.test1.PersonMapper;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2018/12/13 11:14
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<Person> getAll() {
        return personMapper.getAll();
    }

    @Override
    public Person getById(Integer id) {
        return null;
    }

    @Override
    public void insert(Person person) {

    }
}
