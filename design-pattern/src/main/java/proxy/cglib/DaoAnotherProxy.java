package proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/22 15:48
 * 版本：1.0
 * 内容描述：
 */
public class DaoAnotherProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("StartTime=[" + System.currentTimeMillis() + "]");
        //method.invoke(obj, args);
        proxy.invokeSuper(obj, args);
        System.out.println("EndTime=[" + System.currentTimeMillis() + "]");
        return obj;
    }

}
