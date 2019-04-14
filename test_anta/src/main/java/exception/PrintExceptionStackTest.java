package exception;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/4/4 17:46
 */
public class PrintExceptionStackTest {

    private static final Logger logger = LoggerFactory.getLogger(PrintExceptionStackTest.class);

    @Test
    public void testPrintException() {
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            logger.info("do sign exception:", e);
        }
    }

}
