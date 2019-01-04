package _04_number;

import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/12/6 16:49
 */
public class TestFloat {

    public static void main(String[] args) {
        double f1 = 1.60F;
        double f2 = 1.30F;
        System.out.println(f1 + f2); // 2.899999976158142

        BigDecimal addend = new BigDecimal(0.06);
        BigDecimal augend = new BigDecimal(0.01);
        BigDecimal result = addend.add(augend);
        System.out.println(result.doubleValue());
    }

}
