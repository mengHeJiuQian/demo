package org.redisson.testreentrantlock;

/**
 * 内容描述：
 * 创建人：yang.liu
 * 创建时间：2019/7/9 14:53
 * 版本：1.0
 */
public class LoggingWidget extends Widget {
    public synchronized void doSomething(){
        super.doSomething();
    }
}
