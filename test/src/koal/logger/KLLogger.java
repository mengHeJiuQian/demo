package koal.logger;

/**
 * 创建人：yang.liu
 * 创建时间：2020/5/19 12:42
 * 版本：1.0
 * 内容描述：试题三
 *
 * 实现要求：
 * 1、根据以下代码片段，参考log4j/slf4j等公共日志库编写一个自定义的简易日志类；
 * 2、至少需要支持文件输出、控制台输出二种日志输出方式，并支持同时输出到文件和控制台；
 * 3、支持DEBUG/INFO/WARN/ERROR四种日志级别；
 * 4、请合理进行设计模式，进行接口类、抽象类等设计，至少包括FileLogger、ConsoleLogger二个子实现类；
 * 5、注意代码注释书写。
 */

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 对外使用的日志类，日志的打印方式可以设置。
 *
 * 思路：
 * 1. KLLogger用来讲日志收集起来，拼接成带日期的固定格式的字符串。KLLogger中可以设置日志输出方式，日志级别等。
 * 2. KLLogger拼接后的日志交给PrintLogger的子类FileLogger、ConsoleLogger取输出，
 */
public class KLLogger implements Logger {

    private int logLevel;
    private String mark = " [INFO] ";
    private StringBuilder sb = new StringBuilder(200);
    private Date now; //
    private PrintLogger[] printLoggers; //日志记录位置，文件、控制台

    public static void main(String[] args) {

        final KLLogger logger1 = KLLogger.getLogger(KLLogger.class);
        logger1.printLoggers = new PrintLogger[]{new ConsoleLogger()};
        logger1.logLevel = Level.ERROR.ordinal();
        logger1.debug("logger1 debug 1...");
        logger1.debug("logger1 debug 2...");
        logger1.info("logger1 info 1...");
        logger1.warn("logger1 warn 1...");
        logger1.error("logger1 error 1...");

        final KLLogger logger2 = KLLogger.getLogger(KLLogger.class);
        logger2.logLevel = Level.DEBUG.ordinal();
        logger2.printLoggers = new PrintLogger[]{new ConsoleLogger(), new FileLogger()};

        logger2.debug("logger2 debug 1...");
        logger2.debug("logger2 debug 2...");
        logger2.info("logger2 info 1...");
        logger2.warn("logger2 warn 1...");
        logger2.error("logger2 error 1...");

    }

    /**
     * klLoggerClass暂时没用到，此处只是创建对象
     */
    private static KLLogger getLogger(Class<KLLogger> klLoggerClass) {
        KLLogger logger = new KLLogger();
        return logger;
    }


    /**
     * 组装打印的日志记录字符串
     * @param msg
     */
    private synchronized void log(String msg) {
        sb.delete(0, sb.length());
        sb.append(currentDateTime());
        sb.append(mark);

        sb.append(getStackTrace());
        sb.append(msg);

        print(sb.toString());
    }

    // 打印日志行，打印的操作交给ConsoleLogger或者FileLogger
    private void print(String logLine) {
        for (PrintLogger logger : printLoggers) {
            logger.print(logLine);
        }

    }

    // 获取调用位置
    private String getStackTrace() {
        StackTraceElement[] stack = new Exception().getStackTrace();
        return new StringBuilder().append(stack[3].getClassName().replaceAll("\\$\n.$", ""))
                .append("::")
                .append(stack[3].getMethodName())
                .append("()第[" + stack[3].getLineNumber() + "]行：").toString();
    }

    private String currentDateTime() {
        now = new Date();
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now);
    }

    @Override
    public void debug(String msg) {
        if (logLevel <= Level.DEBUG.ordinal()) {
            mark = " [DEBUG] ";
            log(msg);
        }
    }


    @Override
    public void info(String msg) {
        if (logLevel <= Level.INFO.ordinal()) {
            mark = " [INFO] ";
            log(msg);
        }
    }

    @Override
    public void warn(String msg) {
        if (logLevel <= Level.WARN.ordinal()) {
            mark = " [WARN] ";
            log(msg);
        }
    }

    @Override
    public void error(String msg) {
        if (logLevel <= Level.ERROR.ordinal()) {
            mark = " [ERROR] ";
            log(msg);
        }
    }
}
