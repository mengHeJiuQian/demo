package chapter14;

import util.ThreadSafe;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/31 11:10
 * 版本：1.0
 * 内容描述：使用条件队列实现的有界缓存
 */
@ThreadSafe
public class BoundedBuffer<V> extends BaseBoundedBuffer<V> {

    public BoundedBuffer(int capacity) {
        super(capacity);
    }

    // 阻塞并直到 not full
    public synchronized void put(V v) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        doPut(v);
        notifyAll();
    }

    // 阻塞并直到 not empty
    public synchronized V get() throws InterruptedException {
        while (isEmpty())
            wait();
        V v = doTake();
        notifyAll();
        return v;
    }
}
