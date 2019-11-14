package book1.spring5guanwang.ioc.propertysource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @Description:
 * @Author: sheldon
 * @Create Date: 2019/11/13 15:25
 * @Update Date: 2019/11/13 15:25
 */
@Configuration
@PropertySource(value = "classpath:book1/spring5guanwang/ioc/propertysource/app.properties")
public class TestBean {

    @Autowired
    private Environment env;

    public String getTestBeanName() {
        String property = env.getProperty("testbean.name");
        System.out.println("property <<< " + property);
        return property;
    }
}
