package lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/4/12 16:31
 */
public class LambdaStreamTest {

    /**
     * 测试stream会不会扰乱List的顺序。
     */
    @Test
    public void testStreamInList() {
        List list = new ArrayList();
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
        //list.stream().forEach(n - > );
        System.out.println(list.toString());
    }
}
