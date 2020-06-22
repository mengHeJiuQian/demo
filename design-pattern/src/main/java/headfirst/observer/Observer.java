package headfirst.observer;

/**
 * @author: sheldon
 * @Date: 2020/6/22 下午10:39
 * @Version: 1.0
 * Description: 观察者接口-气象站显示屏幕
 */
public interface Observer {

    /**
     * 更新观察者的气象显示信息
     * @param temp
     * @param humidity
     * @param pressure
     */
    void update(float temp, float humidity, float pressure);

}
