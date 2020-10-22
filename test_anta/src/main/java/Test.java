import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import string.DateFormatUtils;

/**
 * 常用测试代码编写在这里，写完即可删除.
 */
public class Test {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:HH:ss.SSS");
        var a = 1595470508 * 1000L;
        System.out.println(a);
        Date date1 = new Date(a);
        Date date2 = new Date(1595470508000L);
        System.out.println(sdf.format(date1));
        System.out.println(sdf.format(date2));
        System.out.println(sdf.format(new Date()));
    }

}
// 1603173717271
// 1382694957
// 1595470508000
// 2147483647