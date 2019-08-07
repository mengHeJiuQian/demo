package singleton;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/7 16:21
 * 版本：1.0
 * 内容描述：通过静态内部类来实现
 */
public class SingletonHolder {

    private static class Holder {
        private static final SingletonHolder instance = new SingletonHolder();
    }

    private SingletonHolder() { }

    public static SingletonHolder getInstance() {
        return Holder.instance;
    }

}
