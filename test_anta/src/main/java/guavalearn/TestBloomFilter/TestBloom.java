package guavalearn.TestBloomFilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/11/27 15:09
 */
public class TestBloom {

    @Test
    public void testSomeBinary() {
        System.out.println(0xFFL);
        System.out.println(0x0.0000000000001P-1022);
        System.out.println(Math.log(0.01));
        System.out.println(Math.log(Math.log(2)));
        System.out.println(Math.log((Math.log(2) * Math.log(2))));
        System.out.println(1);
        System.out.println(~1);
    }

    /**
     * 测试 布隆过滤
     */
    @Test
    public void guavaTest() {
        long star = System.currentTimeMillis();
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                10000000,
                0.01);

        for (int i = 0; i < 10000000; i++) {
            filter.put(i);
        }

        Assert.assertTrue(filter.mightContain(1));
        Assert.assertTrue(filter.mightContain(2));
        Assert.assertTrue(filter.mightContain(3));
        Assert.assertFalse(filter.mightContain(10000000));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - star));
    }

}
