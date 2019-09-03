package com.segmentfault.springcloudlesson2.bootstrap;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建人：yang.liu
 * 创建时间：2019/9/4 0:01
 * 版本：1.0
 * 内容描述：Bootstrap 配置 Bean
 */
@Configuration
public class MyConfiguration  implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        // 获取 PropertySources
        MutablePropertySources propertySources = environment.getPropertySources();
        // 添加新定义的一个PropertySources
        propertySources.addFirst(createPropertySource());
    }

    private PropertySource createPropertySource() {
        Map<String, Object> source = new HashMap<>();
        source.put("name", "小马哥");
        PropertySource propertySource = new MapPropertySource("my-property-source", source);
        return propertySource;
    }

}
