package string;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式化工具类
 */
public class DateFormatUtils {

    public static String parseYearMonthDayJoinDot(Date begin, Date end) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String formatDate = sdf.format(begin) + "-" + sdf.format(end);
        return formatDate;
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(parseYearMonthDayJoinDot(date, date));
    }

}
