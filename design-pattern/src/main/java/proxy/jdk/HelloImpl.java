package proxy.jdk;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/21 23:23
 * 版本：1.0
 * 内容描述：
 */
public class HelloImpl implements IHello {

    @Override
    public void sayHello() {
        System.out.println("Hello World!");
    }

}
