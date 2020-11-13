package collections;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestCollection {

    @Test
    public void sortArrayList() {
        List<User> list = new ArrayList<>();
        list.add(new User("3", "100", "懂得"));
        list.add(new User("1", "99", "张三"));
        list.add(new User("1", "1", "里斯"));
        list.add(new User("2", "100", "对的"));
        // list = new ArrayList<>();
        Collections.sort(list);
        System.out.println(JSON.toJSONString(list));
    }

}
