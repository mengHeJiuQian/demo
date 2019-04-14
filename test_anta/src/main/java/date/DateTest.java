package date;

import java.util.Date;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/4/2 18:13
 */
public class DateTest {
    public static void main(String[] args) {
        Integer expiresDay = null;
        Date date = DateUtils.addDay(new Date(), expiresDay);
        System.out.println(date);
    }
}
