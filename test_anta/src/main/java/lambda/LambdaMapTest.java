package lambda;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/4/23 15:52
 */
public class LambdaMapTest {

    @Test
    public void testMap() {
        User u1 = new User(1, "aaa");
        User u2 = new User(2, null);

        List<User> list = new ArrayList();
        list.add(u1);
        list.add(u2);

        List<String> collect = list.stream().filter(u -> StringUtils.isNotBlank(u.getEmail())).map(u -> u.getEmail()).collect(Collectors.toList());
        List<String> collect2 = list.stream().map(u -> u.getEmail()).filter(mail -> mail!=null).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collect2);

    }



}

class User {
    private Integer id;
    private String email;

    public User(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
