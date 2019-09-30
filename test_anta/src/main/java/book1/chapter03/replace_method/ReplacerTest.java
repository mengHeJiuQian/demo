package book1.chapter03.replace_method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ReplacerTest {
    public static void main(String[] args) {
        String configLocation = "src/main/java/book1/chapter03/replace_method/applicationContext.xml";
        ApplicationContext ac = new FileSystemXmlApplicationContext(configLocation);
        TestChangeMethod test = (TestChangeMethod) ac.getBean("testChangeMethod");
        test.changeMe();
    }
}
