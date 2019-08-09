package proxy.jdk;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/21 23:33
 * 版本：1.0
 * 内容描述：使用JDK动态代理的五个步骤
 *
 * 1. 通过实现InvocationHandler接口来自定义自己的代理拦截器。
 * 2. 通过Proxy.getProxyClass获取动态代理类
 * 3. 通过反射，获取代理类的构造方法
 * 4. 通过构造函数创建代理对象，并将自定义的InvocationHandler实例对象传为参数传入
 * 5. 通过代理类调用目标方法
 */
public class MyProxyTest {

    public static void main(String[] args) throws Exception {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // 第二步
        Class<?> proxyClass = Proxy.getProxyClass(IHello.class.getClassLoader(), IHello.class);
        // 第三步
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        // 第四步
        IHello iHello = (IHello) constructor.newInstance(new MyInvocationHandler(new HelloImpl()));

        iHello.sayHello();

        // Proxy类中有一个将第二、三、四步合并的方法，可以更方便的创建代理对象
        IHello iHello2 = (IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(),
                new Class[]{IHello.class},
                new MyInvocationHandler(new HelloImpl()));
        iHello2.sayHello();
    }

}
