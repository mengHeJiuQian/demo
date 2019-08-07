package chapter16;

import util.ThreadSafe;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/7 11:18
 * 版本：1.0
 * 内容描述：延长初始化占位类模式
 */
@ThreadSafe
public class ResourceFactory {

    private static class ResourceHolder {
        public static Object resource = new Object();
    }

    public static Object getResouce() {
        return ResourceHolder.resource;
    }

}
