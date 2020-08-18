package thread.threadpool.task1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/10 13:00
 * 版本：1.0
 * 内容描述：批量执行MyTask任务，并汇总结果。
 */
public class MyTaskTest {

    public static void main(String[] args) throws InterruptedException {
        // 定义任务数量
        int taskNum = 100;
        MyTask task = new MyTask();
        CountDownLatch countDownLatch = new CountDownLatch(taskNum);
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= taskNum; i++) {
            int n = i;
            exec.execute(() -> {
                int res = 0;
                try {
                    res = task.runTaskAndGetResult(n);
                    task.setTotalCount(res);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                long count = countDownLatch.getCount();
                System.out.println("任务号" + n + "," + "countDownLatch.getCount() = " + count);
            });
        }
        countDownLatch.await();
        System.out.println("计算结果是：" + task.getTotalCount());
        exec.shutdown();
    }

}
