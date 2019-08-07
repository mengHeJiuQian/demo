package chapter16;

import util.ThreadSafe;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/7 11:16
 * 版本：1.0
 * 内容描述：提前初始化
 */
@ThreadSafe
public class EagerInitialization {

    private static Object resource = new Object();

    public static Object getResource() {
        return resource;
    }

}
