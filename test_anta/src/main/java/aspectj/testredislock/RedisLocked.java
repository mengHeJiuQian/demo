package aspectj.testredislock;


import java.lang.annotation.*;

/**
 * @Author: yu.yue
 * @Date: Created in 2018/5/24 10:15
 * @Modified By:
 * @Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RedisLocked {
    String key();
    ReturnValue returnValue();
    BlockTime blockTime();

    @interface ReturnValue {
        Class valueClass();
        String value();
    }

    @interface BlockTime{
        TimeType timeType() default TimeType.SECONDS;
        int value() default 0;//0：不阻塞
        enum TimeType{
            MILLISECONDS,SECONDS,MINUTES,HOURS
        }
    }
}
