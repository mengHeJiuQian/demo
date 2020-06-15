package book1.spring5guanwang.ioc.importanddependson;

/**
 * @Description:
 * @Author: sheldon
 * @Create Date: 2019/11/11 14:44
 * @Update Date: 2019/11/11 14:44
 */
public class EventListenerBean {

    private void initialize() {
        EventManager.getInstance().
                addListener(s ->
                        System.out.println("<<<:" + s));
    }

}
