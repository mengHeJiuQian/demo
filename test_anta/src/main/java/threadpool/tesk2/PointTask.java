package threadpool.tesk2;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/10 14:29
 * 版本：1.0
 * 内容描述：计算用户等级积分的任务
 */


class PointTask implements Callable<Integer> {

    private int customerId;

    public PointTask(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(new Random().nextInt(1000) + 1);
        System.out.println("计算用户积分中。。。");
        // return new Random().nextInt(10) + 1;
        return 1;
    }

}