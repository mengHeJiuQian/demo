package core1.chapter07.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/1/8 11:04
 */
public class LoggerTest {

    public static void main(String[] args) {
        Logger.getGlobal().info("记录日志");
        Logger.getGlobal().setLevel(Level.OFF);
        Logger.getGlobal().info("记录日志");
    }
}
