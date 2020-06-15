package book1.spring5guanwang.ioc.applicationevent;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @Description: 创建一个自定义事件
 * @Author: sheldon
 * @Create Date: 2019/11/14 13:49
 * @Update Date: 2019/11/14 13:49
 */
@Getter
@Setter
public class BlackListEvent extends ApplicationEvent {

    private final String address;
    private final String test;

    public BlackListEvent(Object source, String address, String test) {
        super(source);
        this.address = address;
        this.test = test;
    }
}
