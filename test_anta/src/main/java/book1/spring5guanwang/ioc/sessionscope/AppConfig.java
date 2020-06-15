package book1.spring5guanwang.ioc.sessionscope;

import org.aspectj.weaver.tools.cache.AsynchronousFileCacheBacking;
import org.aspectj.weaver.tools.cache.AsynchronousFileCacheBacking.AsyncCommand;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @Description:
 * @Author: sheldon
 * @Create Date: 2019/11/11 17:12
 * @Update Date: 2019/11/11 17:12
 */
public class AppConfig {

    @Bean
    @RequestScope
    public UserPreferences userPreferences() {
        return new UserPreferences();
    }

    @Bean
    public UserService userService() {
        UserService service = new SimpleUserService();
        // a reference to the proxied userPreferences bean
        service.setUserPreferences(userPreferences());
        return service;
    }

    public AsyncCommand asyncCommand() {
        return new AsyncCommand() {
            @Override
            public AsynchronousFileCacheBacking getCache() {
                return null;
            }
        };
    }

}
