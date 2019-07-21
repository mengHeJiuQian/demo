package chapter07;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/21 10:13
 * 版本：1.0
 * 内容描述：一个仅运行一秒钟的素数生成器
 */
public class PrimeGeneratorTest {

    public static void main(String[] args) throws InterruptedException {
        List<BigInteger> bigIntegers = aSecondOfPrimes();
        System.out.println(bigIntegers);
    }

    public static List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } finally {
            generator.cancel();
        }
        return generator.get();
    }

}
