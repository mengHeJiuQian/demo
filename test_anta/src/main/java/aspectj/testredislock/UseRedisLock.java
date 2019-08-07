package aspectj.testredislock;

import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/10/25 10:37
 */
@Component
public class UseRedisLock {

    @RedisLocked(key = "grantInstance_args[0].userId_args[0].projectId", returnValue = @RedisLocked.ReturnValue(value = "{\"code\":\"20001\",\"message\":\"该用户正在发放或领取优惠券中，请稍后重试\"}", valueClass = DataResult.class), blockTime = @RedisLocked.BlockTime(10))
    public String buyBooks(String[] bookNames) {

        System.out.println("购买了这些书籍：" + Arrays.toString(bookNames));
        return Arrays.toString(bookNames);

    }

}
