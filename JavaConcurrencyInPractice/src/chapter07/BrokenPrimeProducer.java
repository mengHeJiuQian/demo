package chapter07;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/21 10:30
 * 版本：1.0
 * 内容描述：不可靠的取消操作将把生产者置于阻塞的操作中（不要这么做！！！）
 *
 * 可靠的中断操作例子 {@link PrimeProducer}
 */
public class BrokenPrimeProducer extends Thread {

    private final BlockingQueue<BigInteger> queue;
    public volatile boolean cancelled = false;

    /**
     *
     * @param queue
     */
    public BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!cancelled) {
                queue.put(p = p.nextProbablePrime()); //往队列尾部添加元素，队列满，则阻塞。
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
