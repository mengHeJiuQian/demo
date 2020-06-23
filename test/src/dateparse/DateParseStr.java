package dateparse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 创建人：yang.liu
 * 创建时间：2020/5/21 12:35
 * 版本：1.0
 * 内容描述：
 */
public class DateParseStr {
    public static void main(String[] args) throws ParseException {
        String format = new SimpleDateFormat("MM月dd日 HH点mm分").format(new Date());
        System.out.println(format);

        int loop = 1;
        while (true) {
            if (loop == 0) {
                break;
            }
        }

        Date date = new Date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-2-21 12:38:10").getTime());
        System.out.println(date);
    }
}
