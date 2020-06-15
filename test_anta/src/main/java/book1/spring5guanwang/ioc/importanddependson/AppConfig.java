package book1.spring5guanwang.ioc.importanddependson;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description: 配置运行类。
 *
 * @DependsOn控制bean加载顺序
 * @Import是导入通过@Configuration配置的Bean。
 *
 * @Author: sheldon
 * @Create Date: 2019/11/11 14:21
 * @Update Date: 2019/11/11 14:21
 */
@Configuration
//@Component //如果只用@Component注解则会在每次getB()方法中创建新的对象，官网叫“lite模式”
//@ComponentScan("book1.spring5guanwang.ioc.importanddependson")
public class AppConfig {

    @Bean(initMethod = "initialize")
    @DependsOn({"eventListener"})
    public EventPublisherBean eventPublisherBean() {
        return new EventPublisherBean();
    }

    @Bean(name = "eventListener", initMethod = "initialize")
    @Lazy
    public EventListenerBean eventListenerBean () {
        return new EventListenerBean();
    }

    @Bean
    public Object getA() {
        Object b1 = getB();
        System.out.println("getA()" + b1);
        Object b2 = getB();
        System.out.println("getA()" + b2);
        return null;
    }

    @Bean
    public Object getB() {
        Object o = new Object();
        System.out.println("getB()" + o.toString());
        return o;
    }

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

//        new AnnotationConfigApplicationContext().register(AppConfig.class);

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.scan("book1.spring5guanwang.ioc.importanddependson");
        ac.refresh();
    }

}
