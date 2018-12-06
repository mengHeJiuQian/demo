package book1.chapter03.replace_method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReplacerTest {
    public static void main(String[] args) {
        String configLocation = "classpath:book1/chapter03/replace_method/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);
        TestChangeMethod test = (TestChangeMethod) ac.getBean("testChangeMethod");
        test.changeMe();
    }
}
