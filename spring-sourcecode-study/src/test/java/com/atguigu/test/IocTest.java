package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig2;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @author yang.liu
 * @createtime 2020/8/9 17:22
 * @description
 */
public class IocTest {

    private AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void testImport() {
        printBeans(ac);

        Object colorFactoryBean = ac.getBean("colorFactoryBean");
        System.out.println("ColorFactoryBean的类型是:" + colorFactoryBean.getClass());

        Object colorFactoryBean2 = ac.getBean(BeanFactory.FACTORY_BEAN_PREFIX + "colorFactoryBean");
        System.out.println("colorFactoryBean2的类型工厂是:" + colorFactoryBean2.getClass());
    }

    public void printBeans(AnnotationConfigApplicationContext ac) {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

    }

    @Test
    public void test03() {
        // 根据类型获取bean的name
        String[] beanNamesForType = ac.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = ac.getEnvironment();
        String osName = environment.getProperty("os.name");
        System.out.println("当前操作系统是：" + osName);

        for (String name : beanNamesForType) {
            System.out.println(name);
        }

        // 根据类型获取bean的类型
        Map<String, Person> beansOfType = ac.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }
}
