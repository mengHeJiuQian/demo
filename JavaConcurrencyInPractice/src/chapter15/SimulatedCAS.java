package chapter15;

import util.ThreadSafe;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/6 21:14
 * 版本：1.0
 * 内容描述：模拟CAS
 */
@ThreadSafe
public class SimulatedCAS {

    private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized int compareAndSwap(int expectValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectValue) {
            oldValue = newValue;
        }
        return oldValue;
    }

    public synchronized boolean compareAndSet(int expectValue, int newValue) {
        return expectValue == compareAndSwap(expectValue, newValue);
    }

}
