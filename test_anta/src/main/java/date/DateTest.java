package date;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.util.Date;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/4/2 18:13
 */
public class DateTest {

    /**
     * 获取当前年
     */
    @Test
    public void testGetCurrentYear() {
        int value = Year.now().getValue();
        System.out.println(value);

        int year = LocalDate.now().getYear();
        System.out.println(year);
    }

    @Test
    public void testCat() {
        Cat cat = new Cat("tom", LocalDateTime.now());
        String name = cat.getName();
        name = "123";

        LocalDateTime birth = cat.getBirth();
        birth.plusDays(1); // plusDays()方法会返回新的LocalDateTime对象。
        System.out.println(cat.toString());
    }


    @Test
    public void testLocalTime() {
        LocalTime TimeA = LocalTime.of(9, 0, 0);
        LocalTime TimeB = LocalTime.of(9, 0, 0);
        System.out.println(TimeA.isBefore(TimeB));
    }

    public static void main(String[] args) {
        Integer expiresDay = 1;
        Date date = DateUtils.addDay(new Date(), expiresDay);
        System.out.println(date);
    }
}
