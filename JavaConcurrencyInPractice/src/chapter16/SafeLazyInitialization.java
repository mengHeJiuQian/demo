package chapter16;

import util.ThreadSafe;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/7 11:15
 * 版本：1.0
 * 内容描述：线程安全的延迟初始化
 */
@ThreadSafe
public class SafeLazyInitialization {

    private static Object resource;

    public synchronized static Object getInstance() {
        if (resource == null) {
            resource = new Object();
        }
        return resource;
    }

}
