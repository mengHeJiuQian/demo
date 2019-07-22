package proxy.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.jupiter.api.Test;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/22 15:37
 * 版本：1.0
 * 内容描述：
 */
public class CglibTest {

    /**
     * Cglib拦截方法
     */
    @Test
    public void testCglib() {
        DaoProxy daoProxy = new DaoProxy();

        Enhancer enhancer = new Enhancer();

        // 表示设置要代理的类
        enhancer.setSuperclass(Dao.class);

        // 表示设置回调即MethodInterceptor的实现类
        enhancer.setCallback(daoProxy);

        // 使用create()方法生成一个代理对象
        Dao dao = (Dao) enhancer.create();

        dao.update();
        dao.select();
    }

    /**
     * Cglib拦截不同的方法，进行不同的操作
     */
    @Test
    public void testInterceptorMethodCglib() {
        DaoProxy daoProxy = new DaoProxy();
        DaoAnotherProxy daoAnotherProxy = new DaoAnotherProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        // NoOp.INSTANCE是个对象，表示对拦截的方法不进行操作，是一个简单的对象而已。
        enhancer.setCallbacks(new Callback[] {daoProxy, daoAnotherProxy, NoOp.INSTANCE});
        // enhancer.setCallbacks(new Callback[] {NoOp.INSTANCE, daoAnotherProxy, NoOp.INSTANCE});
        enhancer.setCallbackFilter(new DaoFilter());

        Dao dao = (Dao) enhancer.create();
        dao.select();
        dao.update();


    }

    /**
     * 设置构造函数中调用的拦截方法不要被拦截
     */
    @Test
    public void testNoIntercepterConstructorMethodCglib() {
        DaoProxy daoProxy = new DaoProxy();
        DaoAnotherProxy daoAnotherProxy = new DaoAnotherProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallbacks(new Callback[]{daoProxy, daoAnotherProxy});
        enhancer.setCallbackFilter(new DaoFilter());
        enhancer.setInterceptDuringConstruction(false); // 设置构造函数中调用的拦截方法不要被拦截

        Dao dao = (Dao) enhancer.create();
        dao.select();
        dao.update();
    }

}
