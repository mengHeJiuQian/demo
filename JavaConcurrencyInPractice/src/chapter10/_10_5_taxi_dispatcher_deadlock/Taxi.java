package chapter10._10_5_taxi_dispatcher_deadlock;

/**
 * 内容描述：出租车对象，包含位置和目的地两个属性。容易和出租车队dispatcher发生死锁。
 * 创建人：yang.liu
 * 创建时间：2019/7/2 17:46
 * 版本：1.0
 */
public class Taxi {

    private Point location, destination;
    private final Dispatcher dispatcher;

    public Taxi(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public synchronized Point getLocation() {
        return location;
    }

    // 先获取taxi的锁，再获取dispatcher的锁！！！
    public synchronized void setLocation(Point location) {
        this.location = location;
        if (location.equals(destination)) {
            dispatcher.notifyAvailable(this);
        }
    }
}
