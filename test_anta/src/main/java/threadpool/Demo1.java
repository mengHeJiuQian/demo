package threadpool;

import java.util.concurrent.*;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/12/3 16:20
 */
public class Demo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Runnable t1 = () -> System.out.println("exec...");

        Future<?> submit = executorService.submit(t1);
        Object o = submit.get();
        System.out.println(o);

        executorService.shutdown();

    }

}
