package org.redisson.reentrantlock.sample1;

/**
 * 内容描述：synchronized演示可重入锁
 * 创建人：yang.liu
 * 创建时间：2019/7/9 15:13
 * 版本：1.0
 */
public class SynchronizedSample implements Runnable {

    public synchronized void funA() { // 执行funA方法，需要获取对象锁
        // synchronized属于可重入锁，进入funA方法后，拥有了对象锁，所以执行方法funB方法时不受影响。
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId());
        funB();
    }
    public synchronized void funB() { // 执行funB方法，需要获取对象锁
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId());
    }

    @Override
    public void run() {
        funA();
    }

    public static void main(String[] args) {
        SynchronizedSample ss = new SynchronizedSample();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
    }
}
