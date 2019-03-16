package loop;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/3/5 16:16
 */
public class ForEachTest {

    @Test
    public void testForEachNull() {
        HashSet<Object> nullSet = null;
        for (Object obj : nullSet) {
            System.out.println(obj.toString());
        }
    }

}
