package singleton;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/7 16:12
 * 版本：1.0
 * 内容描述：饿汉式单式设计模式的另一种形式
 */
public class LazySingleton2 {

    private static LazySingleton2 instance;

    static {
        instance = new LazySingleton2();
    }

    private LazySingleton2() {
    }

    public static LazySingleton2 getInstance() {
        return instance;
    }
}
