package book1.spring5guanwang.ioc.importanddependson;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Description: 事件管理类，维护监听器列表，通过单例方法获取事件管理器，可以增加监听器或发布事件。
 * @Author: sheldon
 * @Create Date: 2019/11/11 14:28
 * @Update Date: 2019/11/11 14:28
 */
public class EventManager {

    private final List<Consumer<String>> listeners = new ArrayList<>();

    private static class SingletonHolder {
        private static final EventManager instance = new EventManager();
    }

    public static EventManager getInstance() {
        return SingletonHolder.instance;
    }

    public void publish(String message) {
        listeners.forEach(l -> l.accept(message));
    }

    public void addListener(Consumer<String> eventConsumer) {
        listeners.add(eventConsumer);
    }
}
