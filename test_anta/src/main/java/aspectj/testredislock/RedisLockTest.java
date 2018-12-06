package aspectj.testredislock;

import aspectj.TaotaoMall;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RedisLockTest {

    public static void main(String[] args) {
        String configLocation = "classpath:aspectj/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);
        UseRedisLock test = (UseRedisLock) ac.getBean("useRedisLock");
        String[] b = {"123","456"};
        test.buyBooks(b);
    }

}
