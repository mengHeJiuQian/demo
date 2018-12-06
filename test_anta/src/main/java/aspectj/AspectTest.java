package aspectj;

import book1.chapter03.replace_method.TestChangeMethod;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectTest {

    public static void main(String[] args) {
        String configLocation = "classpath:aspectj/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);
        TaotaoMall test = (TaotaoMall) ac.getBean("taotaoMall");
        String[] b = {"123","456"};
        test.buyBooks(b);
    }

}
