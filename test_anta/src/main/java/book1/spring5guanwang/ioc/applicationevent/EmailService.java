package book1.spring5guanwang.ioc.applicationevent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.List;

/**
 * @Description: 发布一个自定义的ApplicationEvent（BlackListEvent）
 * @Author: sheldon
 * @Create Date: 2019/11/14 13:58
 * @Update Date: 2019/11/14 13:58
 */
public class EmailService implements ApplicationEventPublisherAware {

    private List<String> blackList;
    private ApplicationEventPublisher publisher;

    public void setBlackList(List<String> blackList) {
        this.blackList = blackList;
    }

    /**
     * 在配置时，Spring容器将检测到EmailService实现了 ApplicationEventPublisherAware，并将自动调用setApplicationEventPublisher()方法。
     * 实际上，传入的参数将是Spring容器本身;您只需通过ApplicationEventPublisher接口与应用程序上下文进行交互。
     * @param applicationEventPublisher
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void sendEmail(String address, String text) {
        if (blackList.contains(address)) {
            BlackListEvent event = new BlackListEvent(this, address, text);
            publisher.publishEvent(event);
            return;
        }
        // send email...
    }


}
