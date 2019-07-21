package chapter07;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/21 11:15
 * 版本：1.0
 * 内容描述：通过join()方法实现计时运行，中断任务。
 */
public class TimedRunUseJoin {

    public static void timeRun(Runnable r, long timeout, TimeUnit unit) throws Exception {
        class RethrowableTask implements Runnable {
            private volatile Throwable t;
            @Override
            public void run() {
                try {
                    r.run();
                } catch (Throwable t) {
                    this.t = t;
                }
            }
            void rethrow() throws Exception {
                if (null != t) {
                    throw new Exception(t);
                }
            }
        }

        RethrowableTask task = new RethrowableTask();
        Thread taskThread = new Thread(task);
        taskThread.start();

        ScheduledExecutorService cancelExec = Executors.newScheduledThreadPool(1);

        cancelExec.schedule(() -> taskThread.interrupt(), timeout, unit);

        taskThread.join(unit.toMillis(timeout));
        task.rethrow();

    }

}
