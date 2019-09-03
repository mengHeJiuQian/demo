package com.segmentfault.springcloudlesson2.bootstrap;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建人：yang.liu
 * 创建时间：2019/9/4 0:13
 * 版本：1.0
 * 内容描述：
 */
public class MyPropertySourceLocator implements PropertySourceLocator {

    @Override
    public PropertySource<?> locate(Environment environment) {
        if (environment instanceof ConfigurableEnvironment) {
            ConfigurableEnvironment configurableEnvironment = ConfigurableEnvironment.class.cast(environment);
            // 获取 PropertySources
            MutablePropertySources propertySources = configurableEnvironment.getPropertySources();
            // 添加新定义的一个PropertySources
            propertySources.addFirst(createPropertySource());
        }
        return null;
    }

    private PropertySource createPropertySource() {
        Map<String, Object> source = new HashMap<>();
        source.put("spring.applocation.name", "小马哥的Spring Cloud 程序");
        // 设置名称和来源
        PropertySource propertySource = new MapPropertySource("over-bootstrap-property-source", source);
        return propertySource;
    }

}
