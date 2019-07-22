package proxy.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/22 15:52
 * 版本：1.0
 * 内容描述：
 */
public class DaoFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        // 对于方法名等于select的方法进行过滤判断
        if ("select".equals(method.getName())) {
            return 0;
        }
        return 1;
    }

}
