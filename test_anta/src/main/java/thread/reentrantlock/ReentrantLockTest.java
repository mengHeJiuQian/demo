package thread.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2018/12/6 17:07
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        System.out.println("### printf");
        lock.unlock();

    }
}
