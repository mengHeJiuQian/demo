package com.atguigu.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author yang.liu
 * @createtime 2020/8/9 21:45
 * @description
 */
public class ColorFactoryBean implements FactoryBean {

    /**
     * 获取bean的实例，这个实例会放入Spring容器.
     */
    @Override
    public Object getObject() throws Exception {
        System.out.println("ColorFactoryBean...");
        return new Color();
    }

    /**
     * 是否单例.
     */
    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 是否单例.
     * true    该bean是单实例，容器中只有一份
     * false   每次获取都会创建新的实例
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
