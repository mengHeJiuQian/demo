package chapter16;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/7 11:26
 * 版本：1.0
 * 内容描述：资源对象，假想创建该资源对象很复杂
 */
public class Resource {

    private int value;

    public Resource() {
        try {
            System.out.println("开始创建Resouce");
            Thread.sleep(3000);
            value = 10;
            System.out.println("创建Resouce完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Resource{" +
                "value=" + value +
                '}';
    }

}
