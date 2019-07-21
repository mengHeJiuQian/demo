package chapter07;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/21 10:38
 * 版本：1.0
 * 内容描述：通过中断来取消执行任务
 *
 * 不可靠的中断操作例子 {@link BrokenPrimeProducer}
 */
public class PrimeProducer extends Thread {

    private final BlockingQueue<BigInteger> queue;

    public PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted()) { //未中断状态，继续执行
                queue.put(p = p.nextProbablePrime());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cancel() {
        interrupt(); //设置中断状态
    }
}
