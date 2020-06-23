package threadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建人：yang.liu
 * 创建时间：2020/5/22 8:34
 * 版本：1.0
 * 内容描述：
 */
public class TestThreadpool {

    @Test
    public void testSingleThreadExecutor() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.submit();
//        executorService.execute();
    }
}
