package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfigOfLifeCycle;
import com.atguigu.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author yang.liu
 * @createtime 2020/8/11 22:17
 * @description
 */
public class IocTest_PropertyValue {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    @Test
    public void test01() {
        printBeans();

        Person bean = (Person) ac.getBean("person");
        System.out.println(bean);

        // 通过Environment获取配置文件里的属性
        ConfigurableEnvironment environment = ac.getEnvironment();
        String nickName = environment.getProperty("person.nickName");
        System.out.println("person.nickName=" + nickName);
        ac.close();
    }

    public void printBeans() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
