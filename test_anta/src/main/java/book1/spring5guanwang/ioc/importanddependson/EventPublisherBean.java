package book1.spring5guanwang.ioc.importanddependson;

/**
 * @Description: 事件发布类，通过EventManager类发布事件。
 * @Author: sheldon
 * @Create Date: 2019/11/11 14:37
 * @Update Date: 2019/11/11 14:37
 */
public class EventPublisherBean {

    public void initialize() {
        System.out.println(">>>:" + "event published from EventPublisherBean");
        EventManager.getInstance().publish("event published from EventPublisherBean");
    }

}
