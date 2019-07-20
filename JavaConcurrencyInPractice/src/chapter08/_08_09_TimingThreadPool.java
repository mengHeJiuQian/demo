package chapter08;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * 《Java并发编程实战》程序清单8-9
 * 扩展ThreadPoolExecutor，实现一个自定义的线程池，
 * 它通过beforeExecute、afterExecutor和terminated等方法添加日志记录和统计信息收集。
 *
 */
public class _08_09_TimingThreadPool extends ThreadPoolExecutor {

    public _08_09_TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                BlockingQueue<Runnable> workQueue) {
        super(1, 1, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

    private final ThreadLocal<Long> startTime = new ThreadLocal<>();
    private final Logger log = Logger.getLogger("_08_09_TimingThreadPool");

    private final AtomicLong numTasks = new AtomicLong();

    private final AtomicLong totalTime = new AtomicLong();

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        log.fine(String.format("Thread %s: start %s", t, r));
        startTime.set(System.nanoTime());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        try {
            long endTime = System.nanoTime();
            long taskTime = endTime - startTime.get();
            numTasks.incrementAndGet();
            totalTime.addAndGet(taskTime);
            log.fine(String.format("Thread %s: end %s, time=%dns", t, r, taskTime));
        } finally {
            super.afterExecute(r, t);
        }
    }

    protected void terminated() {
        try {
            log.info(String.format("Terminated: avg time=%dns", totalTime.get() / numTasks.get()));
        } finally {
            super.terminated();
        }
        Executors.newFixedThreadPool(10);
    }
}
