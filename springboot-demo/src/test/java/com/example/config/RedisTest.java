package com.example.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2018/12/11 13:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(Application.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws Exception {
//        Person user=new Person("yang.liu@shuyun.com", "qweQWE123!");
//        ValueOperations<String, Person> operations=redisTemplate.opsForValue();
//        operations.set("com.neox", user);
//        operations.set("com.neo.f", user,10, TimeUnit.SECONDS);
//        Thread.sleep(1000);
//        //redisTemplate.delete("com.neo.f");
//        boolean exists=redisTemplate.hasKey("com.neo.f");
//        if(exists){
//            System.out.println("exists is true");
//        }else{
//            System.out.println("exists is false");
//        }
        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }
}
