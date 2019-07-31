package chapter14;

import util.ThreadSafe;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/31 12:49
 * 版本：1.0
 * 内容描述：使用wait和notifyAll来实现可重新关闭的阀门
 */
@ThreadSafe
public class ThreadGate {

    private boolean isOpen;
    private int generation;

    public synchronized void close() {
        isOpen = false;
    }

    public synchronized void open() {
        ++generation;
        isOpen = true;
        notifyAll();
    }

    public synchronized void await() throws InterruptedException {
        int arrivalGeneration = generation;
        while (!isOpen && arrivalGeneration == generation)
            wait();
    }

}
