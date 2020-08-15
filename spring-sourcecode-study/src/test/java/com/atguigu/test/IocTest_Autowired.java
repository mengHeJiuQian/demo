package com.atguigu.test;

import com.atguigu.bean.Boss;
import com.atguigu.bean.Car;
import com.atguigu.config.MainConfigOfAutowired;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: sheldon
 * @Date: 2020/8/15 下午4:30
 * @Version: 1.0
 * Description:
 */
public class IocTest_Autowired {

    @Test
    public void test01() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        Boss boss = ac.getBean(Boss.class);

        Car car = ac.getBean(Car.class);
        System.out.println(boss);
        System.out.println(car);
    }
}
