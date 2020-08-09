package com.atguigu.test;

import com.atguigu.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yang.liu
 * @createtime 2020/8/9 17:22
 * @description
 */
public class IocTest_LifeCycle {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成...");
        ac.close();
    }
}
