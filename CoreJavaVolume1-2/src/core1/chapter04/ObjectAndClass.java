package core1.chapter04;

import java.time.LocalDate;
import java.util.Date;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/1/1 20:11
 */
public class ObjectAndClass {

    public static void main(String[] args) {
        // ----- 日期表示类 -----
        LocalDate newYear1 = LocalDate.now();
        LocalDate newYear2 = LocalDate.of(2019, 1, 1);
        // 返回一个新的LocalDate对象
        // LocalDate lastYear = newYear2.plusDays(-1);
        LocalDate lastYear = newYear2.minusDays(1);

        System.out.println(lastYear);

        // GregorianCalendar类的add()方法会更改原对象的要表示的时间。
        // GregorianCalendar

        Date dateOriginal = new Date();
        Date clone = (Date) dateOriginal.clone();
        System.out.println("原来的时间：" + dateOriginal.toString());
        System.out.println("克隆的时间：" + clone.toString());
        System.out.println("原来的时间和克隆的时间是同一个对象吗？" + (dateOriginal == clone));

        // setOut方法是本地实现，native可以绕过Java语言的存取控制机制
        // System.setOut(); // 该方法可以将System.out设置为不同的流
        // System.out

    }
}
