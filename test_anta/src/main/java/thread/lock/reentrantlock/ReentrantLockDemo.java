package thread.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author：yang.liu
 * @create time：2020/7/23 22:33
 * @version：1.0
 * @description： 可重入锁源码学习
 */
public class ReentrantLockDemo {

    private static int i = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        // 创建一百个线程去对共享变量i进行加一，如果lock有作用，i的最后结果为100.
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                lock.lock();
                addOne();
                lock.unlock();
            }).start();
        }
    }

    public static void addOne() {
        System.out.print("当前lock=" + i + ",");
        System.out.println("处理后lock=" + ++i);
    }
}
