package date;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/4/2 18:13
 */
public class DateTest {
    @Test
    public void testLocalTime() {
        LocalTime TimeA = LocalTime.of(9, 0, 0);
        LocalTime TimeB = LocalTime.of(9, 0, 0);
        System.out.println(TimeA.isBefore(TimeB));
    }

    public static void main(String[] args) {
        Integer expiresDay = null;
        Date date = DateUtils.addDay(new Date(), expiresDay);
        System.out.println(date);
    }
}
