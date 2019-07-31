package chapter14;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/31 10:54
 * 版本：1.0
 * 内容描述：使用简单阻塞实现的有界缓存
 */
public class SleepyBoundedBuffer<V> extends BaseBoundedBuffer<V> {

    private static final int SLEEP_GRANULARITY = 3000;

    public SleepyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public void put(V v) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isFull()) {
                    doPut(v);
                    return;
                }
            }
            Thread.sleep(SLEEP_GRANULARITY);
        }
    }

    public V take() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isEmpty()) {
                    return doTake();
                }
            }
            Thread.sleep(SLEEP_GRANULARITY);
        }
    }
}
