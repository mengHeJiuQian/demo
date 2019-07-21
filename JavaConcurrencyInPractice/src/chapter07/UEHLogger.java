package chapter07;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/21 14:09
 * 版本：1.0
 * 内容描述：将异常写入日志的UncaughtExceptionHandler
 */
public class UEHLogger implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.SEVERE, "Thread terminated with exception: " + t.getName(), e);
    }

}
