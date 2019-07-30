package chapter12;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/30 22:18
 * 版本：1.0
 * 内容描述：自定义线程工厂
 */
public class TestingThreadFactory implements ThreadFactory {

    public final AtomicInteger numCreated = new AtomicInteger();
    private final ThreadFactory factory = Executors.defaultThreadFactory();

    @Override
    public Thread newThread(Runnable r) {
        numCreated.incrementAndGet();
        return factory.newThread(r);
    }

}
