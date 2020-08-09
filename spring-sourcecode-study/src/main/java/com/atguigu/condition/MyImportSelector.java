package com.atguigu.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author yang.liu
 * @createtime 2020/8/9 18:28
 * @description 自定义需要导入的组件
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 这里的返回数组可以直接写为类的全限定类名数组。
        String[] beansName = {"com.atguigu.bean.Blue", "com.atguigu.bean.Red"};
        return beansName;
    }
}
