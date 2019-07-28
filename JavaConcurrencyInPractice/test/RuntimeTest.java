import org.junit.jupiter.api.Test;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/28 10:57
 * 版本：1.0
 * 内容描述：
 */
public class RuntimeTest {

    @Test
    public synchronized void testAvailableProcessors() {
        Runtime runtime = Runtime.getRuntime();
        int i = runtime.availableProcessors();
        System.out.println(i);
    }
}
