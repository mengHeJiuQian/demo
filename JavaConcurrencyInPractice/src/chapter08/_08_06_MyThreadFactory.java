package chapter08;

import java.util.concurrent.ThreadFactory;

/**
 * 自定义线程工厂
 */
public class _08_06_MyThreadFactory implements ThreadFactory {

    private final String poolName;

    public _08_06_MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new _08_07_MyAppThread(r, poolName);
    }

    public static void main(String[] args) {
        _08_06_MyThreadFactory myThreadFactory = new _08_06_MyThreadFactory("aaa");

        //执行一个有错误的任务
        Thread thread = myThreadFactory.newThread(() -> {
            int i = 1 / 0;
        });
        thread.start();
    }
}
