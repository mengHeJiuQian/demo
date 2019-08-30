package com.example.controller;

import com.example.task.ScheduleJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2018/12/10 13:08
 */
@Component
@RestController
public class HelloWorldController {

    @Autowired
    private ScheduleJob job;

    @GetMapping("/hello")
    public String hello(int maxRecord) {
        System.out.println("maxRecord" + maxRecord);
        //job.init();
        job.destroy();
        return "hello,xi-hong-shi-shou-fu";
    }



}
