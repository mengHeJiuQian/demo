package thread.threadpool.tesk2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/10 14:09
 * 版本：1.0
 * 内容描述：通过Future实现多个任务结果汇总
 */
public class TestFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int taskNum = 10000;
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Integer>> pointTaskFutureList = new ArrayList<>(taskNum);
        for (int i = 0; i < taskNum; i++) {
            // 提交任务，任务的执行由线程池去调用执行并管理。这里获取结果任务的Future，并放到list中，供所有任务提交完后，判断每个任务执行的状态和结果。
            Future<Integer> future = executor.submit(new PointTask(i + 1));
            pointTaskFutureList.add(future);
        }

        int total = 0; // 总计算结果
        int done = 0; //完成任务的数量

        while (!pointTaskFutureList.isEmpty()) {
            Iterator<Future<Integer>> iter = pointTaskFutureList.iterator();
            while (iter.hasNext()) {
                Future<Integer> next = iter.next();
                if (next.isDone()) {
                    done++;
                    Integer res = next.get();
                    total += res;
                    iter.remove();
                }
            }
            System.out.println("完成任务量：" + done + " 此时计算结果为：" + total);
            // 停留一会，避免一直循环。
            Thread.sleep(1000L);
        }
        System.out.println("执行完成后，完成任务量：" + done + " 此时计算结果为：" + total);
        executor.shutdown();
    }
}




