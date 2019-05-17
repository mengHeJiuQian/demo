package nullTest;

import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;

/**
 * @Description
 * @Author yang.liu
 * @Date 2019/4/22 19:33
 */
public class NullTest {

    @Test
    public void testStringNull() {
        String a = "";
        String nullString = "123" + a;
        System.out.println(nullString);
        if (StringUtils.isEmpty(a)) {
            System.out.println("afd");
        }
    }

}
