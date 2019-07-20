package chapter08;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class _08_07_MyAppThread extends Thread {

    public static final String DEFAULT_NAME = "MyAppThread";
    private static volatile boolean debugLifecycle = false;
    private static final AtomicInteger created = new AtomicInteger();
    private static final AtomicInteger alive = new AtomicInteger();
    public static final Logger log = Logger.getAnonymousLogger();

    public _08_07_MyAppThread(Runnable r) {
        this(r, DEFAULT_NAME);
    }

    public _08_07_MyAppThread(Runnable r, String defaultName) {
        super(r, defaultName + "-" + created.incrementAndGet());
        setUncaughtExceptionHandler((thread, throwable) ->
                log.log(Level.INFO, "Uncaught in thread " + thread.getName(), throwable));
    }

    @Override
    public void run() {
        boolean debug = debugLifecycle;
        if (debug) {
            log.log(Level.INFO, "Created " + getName());
        }

        try {
            alive.incrementAndGet();
            super.run();
        } finally {
            alive.decrementAndGet();
            if (debug) {
                log.log(Level.INFO, "Exiting " + getName());
            }
        }
    }
}
