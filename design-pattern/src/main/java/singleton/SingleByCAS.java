package singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/7 16:32
 * 版本：1.0
 * 内容描述：通过CAS工具类实现单例
 */
public class SingleByCAS {

    private static AtomicReference<SingleByCAS> instance = new AtomicReference<>();

    private SingleByCAS() { }

    public static SingleByCAS getInstance() {
        SingleByCAS old;
        do {
            old = instance.get();
            if (old != null) {
                return old;
            }
            old = new SingleByCAS();
        } while (!instance.compareAndSet(null, old));
        return old;
    }
}
