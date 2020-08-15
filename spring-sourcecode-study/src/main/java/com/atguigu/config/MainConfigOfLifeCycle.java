package com.atguigu.config;

import com.atguigu.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author yang.liu
 * @createtime 2020/8/9 22:06
 * @description
 *
 * 创建和销毁bean的方式。
 *
 * 方式一：
 * 通过@Bean注解里initMethod和destroyMethod的方法设置
 *
 * 方式二：
 * 通过Spring提供的InitializingBean, DisposableBean接口初始化和销毁bean.
 *
 * 方式三：
 * 使用JSR250
 * @PostConstruct 在bean创建完成，并且属性复制完成，执行初始化方法.
 * @PreDestroy 在容器销毁bean之前通知进行一些清理工作.
 */
@ComponentScan("com.atguigu.bean")
@Configuration
public class MainConfigOfLifeCycle {

    /**
     * 如果bean是单实例，容器启动时创建对象，执行初始化方法，容器关闭时执行销毁方法.
     * 如果bean是多实例，获取实例时才会创建对象，执行初始化方法，容器关闭时不会执行销毁方法，销毁方法什么是否执行自己定义.
     * @return
     */
//    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}
