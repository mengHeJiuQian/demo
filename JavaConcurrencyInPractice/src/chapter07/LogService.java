package chapter07;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/21 13:10
 * 版本：1.0
 * 内容描述：向LogWriter添加可靠的取消操作
 */
public class LogService {
    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    private final LoggerThread loggerThread = new LoggerThread();
    private final PrintWriter writer = new PrintWriter(System.out);
    private boolean isShutdown;
    private int reservations;

    public void start() {
        loggerThread.start();
    }

    public void stop() {
        synchronized (this) {
            isShutdown = true;
            loggerThread.interrupt();
        }
    }

    public void log(String msg) throws InterruptedException {
        synchronized (this) {
            if (isShutdown) {
                throw new IllegalStateException();
            }
            ++reservations;
        }
        queue.put(msg);
    }

    private class LoggerThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    try {
                        synchronized (LogService.this) {
                            if (isShutdown && 0 == reservations) {
                                break;
                            }
                        }
                        String msg = queue.take();
                        synchronized (LogService.this) {
                            --reservations;
                        }
                        writer.println(msg);
                    } catch (InterruptedException e) {
                        // 可以重试
                        e.printStackTrace();
                    }
                }
            } finally {
                writer.close();
            }
        }
    }
}

