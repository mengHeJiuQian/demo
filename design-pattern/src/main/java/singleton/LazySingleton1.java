package singleton;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/7 16:12
 * 版本：1.0
 * 内容描述：饿汉式单式设计模式
 */
public class LazySingleton1 {

    private static LazySingleton1 instance = new LazySingleton1();

    private LazySingleton1() { }

    public static LazySingleton1 getInstance() {
        return instance;
    }
}
