package string;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        String originDateText = "2020年11月11日";
        String originFormat = "yyyy年M月d日";
        String toFormatText = "yyyy-MM-dd";
        LocalDate localDate = LocalDate.parse(originDateText, DateTimeFormatter.ofPattern(originFormat));

        String format = localDate.format(DateTimeFormatter.ofPattern(toFormatText));
        System.out.println(format);
    }


}
