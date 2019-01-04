package com.example.controller;

import com.example.domain.Person;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/1/4 17:32
 */
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/getUsers")
    public List<Person> getUsers() {
        List<Person> users = personService.getAll();
        return users;
    }

//    @RequestMapping("/getUser")
//    public UserEntity getUser(Long id) {
//        UserEntity user=user2Mapper.getOne(id);
//        return user;
//    }
//
//    @RequestMapping("/add")
//    public void save(UserEntity user) {
//        user2Mapper.insert(user);
//    }
//
//    @RequestMapping(value="update")
//    public void update(UserEntity user) {
//        user2Mapper.update(user);
//    }
//
//    @RequestMapping(value="/delete/{id}")
//    public void delete(@PathVariable("id") Long id) {
//        user1Mapper.delete(id);
//    }

}
