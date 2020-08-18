package core1.chapter08.pair2;

import java.util.Map;

/**
 * describe: 定义一个泛型方法
 *
 * @author 梦合九千
 * @date 2019/1/8 12:08
 */
public class ArrayAlg {

    // 泛型方法可以定义在普通类中，也可以定义在泛型类中
    // 类型变量放在修饰符后面，返回类型之前
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    /**
     * 对类型变量进行限定，此处定义的类型必须是Comparable的实现类或者是Map实现类。
     */
    public static <T extends Comparable & Map> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min, max);
    }

}
