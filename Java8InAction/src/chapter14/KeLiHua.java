package chapter14;

import java.util.function.DoubleUnaryOperator;

public class KeLiHua {
    public static void main(String[] args) {

    }

    /**
     *
     * @param x 希望转换的数量
     * @param f 转换因子
     * @param b 基线值
     * @return
     */
    public static double converter(double x, double f, double b) {
        return x * f + b;
    }

    /**
     * 科里化：一种将具备两个参数的函数f转化为使用使用一个参数的函数g
     * @param f
     * @param b
     * @return
     */
    public static DoubleUnaryOperator curriedConverter(double f, double b) {
        return (double x) -> x * f + b;
    }

}
