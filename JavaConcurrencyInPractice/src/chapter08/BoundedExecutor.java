package chapter08;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/28 13:30
 * 版本：1.0
 * 内容描述：使用Semaphore来控制任务的提交速率
 */
public class BoundedExecutor {

    private final Executor exec;
    private final Semaphore semaphore;

    public BoundedExecutor(Executor exec, Semaphore semaphore) {
        this.exec = exec;
        this.semaphore = semaphore;
    }

    public void submitTask(final Runnable command) throws InterruptedException {
        semaphore.acquire();
        try {

            exec.execute(() -> {
            try {
                command.run();
            } finally {
                semaphore.release();
            }
            });
        } catch (RejectedExecutionException e) {
            semaphore.release();
        }
    }
}
