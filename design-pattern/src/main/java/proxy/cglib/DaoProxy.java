package proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/22 15:33
 * 版本：1.0
 * 内容描述：
 */
public class DaoProxy implements MethodInterceptor {

    /**
     * @param o 表示要进行增强的对象
     * @param method 表示拦截的方法
     * @param objects 数组表示参数列表，基本数据类型需要传入其包装类型，如int-->Integer、long-Long、double-->Double
     * @param methodProxy 表示对方法的代理，invokeSuper方法表示对被代理对象方法的调用
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行前置代码");
        methodProxy.invokeSuper(o, objects);
        System.out.println("执行后置代码");
        return o;
    }

}
