package beans;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yang.liu
 * @createtime 2020/8/12 13:17
 * @description
 */
public class BeanTest {

    @Test
    public void testGetBean() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) ac.getBean("person");
        System.out.println(person);
    }
}
