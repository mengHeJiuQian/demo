package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2018/12/10 13:08
 */
@Component
@Path("/shop/selector")
public class HelloWorldController {


    @POST
    @Path("/hello")
    public String hello(@QueryParam("maxRecord") int maxRecord) {
        System.out.println("maxRecord" + maxRecord);
        return "hello,xi-hong-shi-shou-fu";
    }



}
