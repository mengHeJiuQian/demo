package headfirst.observer;

/**
 * @author: sheldon
 * @Date: 2020/6/22 下午10:37
 * @Version: 1.0
 * Description: 气象站主体接口
 */
public interface Subject {

    /**
     * 注册观察者-气象显示器
     * @param o
     */
    void registerObserver(Observer o);

    /**
     * 移除观察者-气象显示器
     * @param o
     */
    void removeObserver(Observer o);

    /**
     * 观察者数据更新，通知观察者
     */
    void notifyObservers();

}
