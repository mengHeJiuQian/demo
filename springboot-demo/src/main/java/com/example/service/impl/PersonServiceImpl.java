package com.example.service.impl;

import com.example.dao.PersonMapper;
import com.example.domain.Person;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Person getAll() {
        return null;
    }

    @Override
    public Person getById(Integer id) {
        return null;
    }

    @Override
    public void insert(Person person) {

    }
}
