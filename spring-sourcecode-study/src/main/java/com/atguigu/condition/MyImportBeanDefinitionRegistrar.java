package com.atguigu.condition;

import com.atguigu.bean.RainBow;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author yang.liu
 * @createtime 2020/8/9 18:44
 * @description 自定义注册bean
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 如果红色和蓝色都被注册，则自定义注册RainBow彩虹类.
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean blue = registry.containsBeanDefinition("com.atguigu.bean.Blue");
        boolean red = registry.containsBeanDefinition("com.atguigu.bean.Red");
        if (blue && red) {
            BeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            registry.registerBeanDefinition("rainBow", beanDefinition);
        }
    }
}
