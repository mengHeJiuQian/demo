package thread.future;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * 内容描述：异步执行任务
 * 创建人：yang.liu
 * 创建时间：2019/7/10 0:37
 * 版本：1.0
 */
public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Long> task1 = new FutureTask<>(new GrantCouponTask());
        FutureTask<Long> task2 = new FutureTask(new GrantCouponTask());

        ExecutorService exec = Executors.newFixedThreadPool(1);

        exec.submit(task1);
        exec.submit(task2);

        System.out.println(task1.get());
        System.out.println(task2.get());

        exec.shutdown();
    }

    private static class GrantCouponTask implements Callable<Long> {
        @Override
        public Long call() throws Exception {
            for (int i = 0; i < 100; i++) {
                System.out.println("grant coupon " + ++i);
                Thread.sleep(20);
            }
            return 100L;
        }
    }

}
