package chapter07;

import java.util.concurrent.*;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/21 11:47
 * 版本：1.0
 * 内容描述：通过Future取消任务
 */
public class TimedRunUseFuture {

    public static void timeRUn(Runnable r, long timeout, TimeUnit unit) {
        ExecutorService taskExec = Executors.newFixedThreadPool(1);
        Future<?> task = taskExec.submit(r);
        try {
            task.get(timeout,unit);
        } catch (ExecutionException e) {
            // 执行任务中抛出异常，那么重新抛出该异常
        } catch (TimeoutException e) {
            // 任务将被取消
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            task.cancel(true); //是否能够接受中断
        }

    }
}
