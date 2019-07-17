package lambda.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/17 14:25
 * 版本：1.0
 * 内容描述：
 */
public class OptionalSample {

    /**
     * 测试Optional类对空的操作
     */
    @Test
    public void test() {
        User user = new User("1", null);
        Optional<User> userOptional = Optional.ofNullable(user);
        String username = userOptional.map(User::getUsername).orElseGet(null);
        System.out.println("-" + username + "-");
    }
}
