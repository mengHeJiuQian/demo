package _05_thread.longadder;

import java.util.concurrent.atomic.LongAdder;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2018/12/6 17:35
 */
public class LongAdderTest {

    public static void main(String[] args) {
        LongAdder add = new LongAdder();
        add.increment();
        System.out.println(add.longValue());
    }
}
