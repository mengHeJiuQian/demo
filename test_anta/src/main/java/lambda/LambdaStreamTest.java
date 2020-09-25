package lambda;

import com.alibaba.fastjson.JSON;
import java.util.Optional;
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

    /**
     * 测试stream list is null.
     */
    @Test
    public void testStreamListIsNull() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("aaa", 1));
        list.add(new Person("bbb", 2));
        list.add(new Person("ccc", 3));
//        long count = Stream.of(list).count();
        Optional.ofNullable(list)
                .orElse(new ArrayList<>())
                .stream()
                .forEach(p -> {
                    System.out.println("a");
                    p.setName(p.getName() + "#");
                });
        System.out.println(JSON.toJSONString(list));
    }
}
