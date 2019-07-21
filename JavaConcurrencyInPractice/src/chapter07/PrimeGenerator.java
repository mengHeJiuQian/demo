package chapter07;

import util.ThreadSafe;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/21 10:06
 * 版本：1.0
 * 内容描述：素数生成器
 */
@ThreadSafe
public class PrimeGenerator implements Runnable {

    private final List<BigInteger> primes = new ArrayList<>();
    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }
}
