package chapter15;

import util.ThreadSafe;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/6 21:19
 * 版本：1.0
 * 内容描述：基于CAS实现的模拟的非阻塞计数器
 */
@ThreadSafe
public class CasCounter {

    private SimulatedCAS value;

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        } while (v != value.compareAndSwap(v, v+1));
        return v + 1;
    }
}
