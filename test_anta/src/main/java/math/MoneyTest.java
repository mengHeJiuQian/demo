package math;

import org.junit.jupiter.api.Test;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/4/25 22:07
 */
public class MoneyTest {

    @Test
    public void testRateAt_10() {
        double year01 = 10_0000D;
        System.out.println("初始资金：" + year01);
        for (int i = 1; i <= 10; i++) {
            year01 *= 1.1;
            System.out.println("投资第" + i + "年，资金为：" + year01 + "元。");
        }
    }
}
