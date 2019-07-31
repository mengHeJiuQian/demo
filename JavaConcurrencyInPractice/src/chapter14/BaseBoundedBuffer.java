package chapter14;

import util.ThreadSafe;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/31 10:29
 * 版本：1.0
 * 内容描述：有界缓存实现的基类
 */
@ThreadSafe
public class BaseBoundedBuffer<V> {

    private final V[] buf;
    private int head;
    private int tail;
    private int count;

    public BaseBoundedBuffer(int capacity) {
        this.buf = (V[]) new Object[capacity];
    }

    protected synchronized final void doPut(V v) {
        buf[tail] = v;
        if (++tail == buf.length) {
            tail = 0;
        }
        ++count;
    }

    protected synchronized final V doTake() {
        V v = buf[head];
        if (++head == buf.length) {
            head = 0;
        }
        --count;
        return v;
    }

    public synchronized final boolean isFull() {
        return count == buf.length;
    }

    public synchronized final boolean isEmpty() {
        return count == 0;
    }

}
