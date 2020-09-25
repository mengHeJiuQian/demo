package number;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/12/6 16:49
 */
public class TestFloat {

    /**
     * 测试NaN（Not a Number）和NaN不是相等的
     * 参考https://codeday.me/bug/20181108/359851.html
     */
    @Test
    public void testIsNaNMethod() {
        System.out.println(Float.isNaN(0.0f / 0.0f));
        System.out.println(Double.isNaN(Math.sqrt(-1)));
        System.out.println(Double.isNaN(Math.sqrt(-2)));
    }

    // 测试float类型存储浮点数
    @Test
    public void testFloat() {
        System.out.println(0.2 + 0.1);
        System.out.println(0.3 - 0.1);
        System.out.println(0.2 * 0.1);
        System.out.println(0.3 / 0.1);

        double f1 = 1.60F;
        double f2 = 1.30F;
        System.out.println(f1 + f2); // 2.899999976158142

        BigDecimal addend = new BigDecimal(0.06);
        BigDecimal augend = new BigDecimal(0.01);
        BigDecimal result = addend.add(augend);
        System.out.println(result.doubleValue());

        DecimalFormat df=new DecimalFormat("000,000.000￥");
        String str = df.format(result);
        System.out.println(str);
    }

    // 测试BigDecimal类型存储浮点数
    @Test
    public void testBigDecimal() {
        BigDecimal bInt = new BigDecimal(2);
        // 不推荐 bDouble=2.29999999999999982236431605997495353221893310546875
        BigDecimal bDouble = new BigDecimal(2.3);
        BigDecimal bString = new BigDecimal("2.3");
        System.out.println("bigDecimal=" + bInt);
        System.out.println("bDouble=" + bDouble);
        System.out.println("bString=" + bString);
    }

    // 测试BigDecimal的加减乘除功能
    @Test
    public void testMathematical() {
        BigDecimal a = new BigDecimal(12);
        BigDecimal b = new BigDecimal(7);

//        BigDecimal a = new BigDecimal(2);
//        BigDecimal b = new BigDecimal(3);
//
//        BigDecimal a = new BigDecimal(2);
//        BigDecimal b = new BigDecimal(3);

        System.out.println(a.add(b));
        System.out.println(a.subtract(b));
        System.out.println(a.multiply(b));
        System.out.println(a.divide(b));

    }

}
