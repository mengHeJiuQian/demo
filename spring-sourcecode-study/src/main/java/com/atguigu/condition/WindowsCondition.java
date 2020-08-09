package com.atguigu.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author yang.liu
 * @createtime 2020/8/9 17:39
 * @description
 */
public class WindowsCondition implements Condition {

    /**
     * 判断当前系统是不是windows
     * @param context 判断条件使用的上下文
     * @param metadata 注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        if (environment.getProperty("os.name").contains("Windows")) {
            return true;
        }
        return false;
    }
}
