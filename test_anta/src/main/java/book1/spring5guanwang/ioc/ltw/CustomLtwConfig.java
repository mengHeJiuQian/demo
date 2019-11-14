package book1.spring5guanwang.ioc.ltw;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

/**
 * @Description: 测试加载时完成织入的代理类的创建，并交给spring管理。 这个例子不能运行，会出错。
 * LTW参考Spring官网的例子：https://www.cntofu.com/book/95/3/3-14.md
 * @Author: sheldon
 * @Create Date: 2019/11/13 16:12
 * @Update Date: 2019/11/13 16:12
 */
@Configuration
@ComponentScan("book1.spring5guanwang.ioc.ltw")
@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.ENABLED)
public class CustomLtwConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(CustomLtwConfig.class);
        ac.refresh();
        LtwBean bean = ac.getBean(LtwBean.class);
        bean.test();
    }

}
