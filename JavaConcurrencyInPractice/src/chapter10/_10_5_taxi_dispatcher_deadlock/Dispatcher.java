package chapter10._10_5_taxi_dispatcher_deadlock;

import java.util.HashSet;
import java.util.Set;

/**
 * 内容描述：出租车队。容易和出租车对象taxi发生死锁。
 * 创建人：yang.liu
 * 创建时间：2019/7/2 17:49
 * 版本：1.0
 */
public class Dispatcher {
    private final Set<Taxi> taxis;
    private final Set<Taxi> availableTaxis;

    public Dispatcher() {
        this.taxis = new HashSet<>();
        this.availableTaxis = new HashSet<>();
    }

    public synchronized void notifyAvailable(Taxi taxi) {
        availableTaxis.add(taxi);
    }

    // 先获取dispatcher的锁，再获取taxi的锁！！！
    public synchronized Image getImage() {
        Image image = new Image();
        for (Taxi t : taxis) {
            image.drawMarker(t.getLocation());
        }
        return image;
    }

}
