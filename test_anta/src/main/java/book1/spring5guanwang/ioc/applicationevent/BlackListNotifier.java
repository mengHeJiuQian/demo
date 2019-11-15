package book1.spring5guanwang.ioc.applicationevent;

import org.springframework.context.ApplicationListener;

/**
 * @Description:
 * @Author: sheldon
 * @Create Date: 2019/11/14 14:13
 * @Update Date: 2019/11/14 14:13
 */
public class BlackListNotifier implements ApplicationListener<BlackListEvent> {

    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @Override
    public void onApplicationEvent(BlackListEvent event) {

    }
}
