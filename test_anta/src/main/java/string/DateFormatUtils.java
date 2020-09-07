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






DGT_01("01","身份证",WeChatConstants.SYSTEM_NAME_DGT),
DGT_02("02","护照",WeChatConstants.SYSTEM_NAME_DGT),
DGT_03("03","其他",WeChatConstants.SYSTEM_NAME_DGT),
DGT_04("04","军人证",WeChatConstants.SYSTEM_NAME_DGT),
DGT_05("05","台胞证",WeChatConstants.SYSTEM_NAME_DGT),
DGT_06("06","港澳通行证",WeChatConstants.SYSTEM_NAME_DGT),
DGT_07("07","户口本",WeChatConstants.SYSTEM_NAME_DGT),
DGT_08("08","出生证",WeChatConstants.SYSTEM_NAME_DGT),
DGT_09("09","港澳居民居住证",WeChatConstants.SYSTEM_NAME_DGT),
DGT_10("10","台湾居民居住证",WeChatConstants.SYSTEM_NAME_DGT),
DGT_11("11","工商营业执照",WeChatConstants.SYSTEM_NAME_DGT),
DGT_12("12","纳税人登记证",WeChatConstants.SYSTEM_NAME_DGT);


}
