package com.segmentfault.springcloudlesson1.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/17 16:34
 * 版本：1.0
 * 内容描述：Spring 事件 / 监听器 Demo
 */
public class SpringEventListenerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 增加监听器
        context.addApplicationListener(new MyApplicationListener());

        // 注册
        context.register(MyApplicationListener.class);

        // 上下文启动
        context.refresh();

        // 发布事件
        context.publishEvent(new MyApplicationEvent("Hello World"));
        context.publishEvent(new MyApplicationEvent("Hello World"));
        //context.publishEvent(new MyApplicationEvent(null));



    }

    /**
       事件监听器
     */
    @Component
    private static class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {
        @Override
        public void onApplicationEvent(MyApplicationEvent event) {
            System.out.printf("MyApplicationListener receives event soource : %s \n", event.getSource());
        }
    }

    /**
       事件
     */
    private static class MyApplicationEvent extends ApplicationEvent {
        public MyApplicationEvent(Object source) {
            super(source);
        }
    }
}
