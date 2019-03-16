package shifting;

import org.junit.jupiter.api.Test;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/3/8 11:41
 */
public class ShiftingTest {

    @Test
    public void leftShiftOperation() {
        /*for (int i = 0; i < 1000; i++) {
            int v = (int) ((Math.random() * 100) + 1) * 1024 * 1024;
            System.out.println(v);

        }*/

        System.out.println(100663296 >> 20 );
        System.out.println(100663296 / 1024 / 1024 );
        System.out.println(100663296 > 100 << 20);
    }

}
