package core1.chapter07.trycatch;

import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/1/7 22:07
 */
public class TryCatchTest {

    public static void main(String[] args) {
        int x = 2133333333;
        float xx = x;
        System.out.println(xx);
        float y = 1F;
        x = (int) (x + y);
        System.out.println(y);
        System.out.println(x);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Float.MAX_VALUE);
        try {
            int j = 2 / 0;
        } catch (NullPointerException e) {
            e = null;
            e.printStackTrace();
        } catch (ArithmeticException ee) {
            ee.printStackTrace();
        }
    }

}
