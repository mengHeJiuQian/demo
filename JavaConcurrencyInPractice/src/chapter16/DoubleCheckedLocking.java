package chapter16;

import util.NotThreadSafe;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/7 11:20
 * 版本：1.0
 * 内容描述：双重检查加锁
 */
@NotThreadSafe
public class DoubleCheckedLocking {

    private static Resource resource;

    public static Resource getInstance() {
        if (resource == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (resource == null) {
                    resource = new Resource();
                }
            }
        }
        return resource;
    }

    public static void main(String[] args) {
        for (int i = 0; i <10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Resource instance = DoubleCheckedLocking.getInstance();
                    System.out.println(instance.toString());
                }
            }).start();
        }
    }

}
