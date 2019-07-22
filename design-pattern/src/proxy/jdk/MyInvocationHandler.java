package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/21 23:25
 * 版本：1.0
 * 内容描述：
 */
public class MyInvocationHandler implements InvocationHandler {

    /** 目标对象 */
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---开始执行代理业务---");
        Object result = method.invoke(target, args);
        System.out.println("---执行代理业务结束---");
        return result;
    }

}
