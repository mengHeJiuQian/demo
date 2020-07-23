package org.redisson.reentrantlock.sample2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 内容描述：ReentrantLock演示可重入锁
 * 创建人：yang.liu
 * 创建时间：2019/7/9 15:14
 * 版本：1.0
 */
public class ReentrantLockSample implements Runnable {

    ReentrantLock lock = new ReentrantLock();

    public void funA() { // 执行funA方法，需要获取对象锁
        lock.lock(); // 第一次获取锁
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId());
        funB(); // 该方法会第二次获取锁
        lock.unlock();
    }
    public void funB() { // 执行funB方法，需要获取对象锁
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId());
        lock.unlock();
    }

    @Override
    public void run() {
        funA();
    }

    public static void main(String[] args) {
        ReentrantLockSample rs = new ReentrantLockSample();
        new Thread(rs).start();
        new Thread(rs).start();
        new Thread(rs).start();
    }
}
