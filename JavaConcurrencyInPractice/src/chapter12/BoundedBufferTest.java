package chapter12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/30 18:03
 * 版本：1.0
 * 内容描述：
 */
public class BoundedBufferTest {

    @Test
    public void testIsEmptyWhenConstructed() {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        assertTrue(bb.isEmpty());
        assertTrue(bb.isFull());
    }

    @Test
    public void testIsFullAfterPuts() throws InterruptedException {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);;
        for (int i = 0; i < 10; i++) {
            bb.put(i);
        }
        assertTrue(bb.isFull());
        assertTrue(bb.isEmpty());
    }

    private static final int LOCKUP_DETECT_TIMEOUT = 3000;
    /**
     * 测试阻塞行为以及对中断的响应性
     */
    @Test
    public void testTakeBlockWhenEmpty() {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);;
        Thread taker = new Thread() {
            @Override
            public void run() {
                try {
                    bb.take();
                    fail(); // 执行到这里，则是错误行为
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        try {
            taker.start();
            Thread.sleep(LOCKUP_DETECT_TIMEOUT);
            taker.interrupt();
            taker.join(LOCKUP_DETECT_TIMEOUT);
            assertFalse(taker.isAlive());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
