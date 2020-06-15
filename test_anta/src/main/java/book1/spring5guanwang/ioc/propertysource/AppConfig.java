package book1.spring5guanwang.ioc.propertysource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @Description:
 *
 * @PropertySource注解对添加一个PropertySource到Spring的环境变量中提供了一个便捷的和声明式的机制。
 * 给出一个名为”app.properties”的文件，获取其中testbean.name的值
 *
 * @Author: sheldon
 * @Create Date: 2019/11/13 15:19
 * @Update Date: 2019/11/13 15:19
 */
@Configuration
@Import(TestBean.class)
public class AppConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(AppConfig.class);
        ac.refresh();

        TestBean bean = ac.getBean(TestBean.class);
        bean.getTestBeanName();
    }
}
