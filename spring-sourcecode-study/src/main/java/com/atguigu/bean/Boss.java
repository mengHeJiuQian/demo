package com.atguigu.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yang.liu
 * @createtime 2020/8/14 22:15
 * @description
 */
@Component
public class Boss {

    private Car car;

    // 通过有参构造器注入
//    @Autowired
    public Boss(Car car) {
        System.out.println("Boss有参构造器注入");
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    /**
     * @Autowired标注在方法上，Spring容器创建当前对象后，调用次方法，完成赋值。
     * @param car
     */
//    @Autowired
    public void setCar(Car car) {
        System.out.println("Boss的setter方法注入");
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
