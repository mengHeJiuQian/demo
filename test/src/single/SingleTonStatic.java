package single;

/**
 * 创建人：yang.liu
 * 创建时间：2020/5/21 12:20
 * 版本：1.0
 * 内容描述：
 */
public class SingleTonStatic {

    private SingleTonStatic() {}

    private static class SingleHolder {
        private static SingleTonStatic INSTANCE = new SingleTonStatic();
    }

    public SingleTonStatic getInstance() {
        return SingleHolder.INSTANCE;
    }
}
