package utils.datetime;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间处理工具类.
 */
@Slf4j
public class DateUtil {

    /**
     * DATE_YYYY_MM_DD.
     */
    public static final String DATE_YYYY_MM_DD = "yyyy-MM-dd";
    /**
     * DATE_YYYY_MM_DD_HH_MM_SS.
     */
    public static final String DATE_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    /**
     * DATE_YYYYMMDDHHMMSSSSS.
     */
    public static final String DATE_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
    /**
     * DATE_YYYYMMDDHHMMSS.
     */
    public static final String DATE_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    /**
     * DATE_YYYY_MM_DD_HH_MM.
     */
    public static final String DATE_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    /**
     * DATE_YYYYMMDD.
     */
    public static final String DATE_YYYYMMDD = "yyyyMMdd";
    /**
     * DATE_HH_MM.
     */
    public static final String DATE_HH_MM = "HH:mm";
    /**
     * DATE_HHMMSSSSS.
     */
    public static final String DATE_HHMMSSSSS = "HHmmssSSS";
    /**
     * YY_MM_DDMMSS.
     */
    public static final String YY_MM_DDMMSS = "yyMMddHHmmss";
    /**
     * ONE_DAY_MILLISENCONDS.
     */
    public static final long ONE_DAY_MILLISENCONDS = 24 * 3600 * 1000;
    /**
     * DATE_YY_MM_DDMMSS.
     */
    public static final String DATE_YY_MM_DDMMSS = "yyyy/MM/dd";

    /**
     * DATE_YYYY_MM_DD_HH_MM_ZH.
     */
    public static final String DATE_YYYY_MM_DD_HH_MM_ZH = "yyyy年MM月dd日 HH:mm";

    /**
     * DATE_YYYY_MM_DD_HH_MM_SS_ZH.
     */
    public static final String DATE_YYYY_MM_DD_HH_MM_SS_ZH = "yyyy年MM月dd日 HH:mm:ss";

    /**
     * DATE_YYYY_MM_DD_ZH.
     */
    public static final String DATE_YYYY_MM_DD_ZH = "yyyy年MM月dd日";

    /**
     * DATE_YYYY_MM_DD_HH_MM_SS_SSS.
     */
    public static final String DATE_YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 解决时区问题.
     */
    public static final ZoneId WECHAT_CN_ZONE_ID = ZoneId.of("Asia/Shanghai");

    /**
     * 9点开始, 包含 9 点.
     */
    private static final LocalTime WECHAT_SELFHELP_OPEN_TIME = LocalTime.of(9, 0, 0);

    /**
     * 21 点结束, 包含 21:0:0 整点.
     */
    private static final LocalTime WECHAT_SELFHELP_CLOSE_TIME = LocalTime.of(21, 0, 0);

    /**
     * 17 点结束, 包含 17:0:0 整点.
     */
    private static final LocalTime WECHAT_SELFHELP_FIVE_PM = LocalTime.of(17, 0, 0);

    /**
     * date2String.
     */
    public static String date2String(Date date, String format) {
        if (date == null || format == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    /**
     * string2date.
     */
    public static Date string2date(String dateString, String format) {
        Date retDate = null;
        if (format == null) {
            format = DATE_YYYY_MM_DD_HH_MM_SS;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            //20191011 added by Somnus(增加强校验，如2018-13-12 不会转化为2019-01-12)
            sdf.setLenient(false);
            retDate = sdf.parse(dateString);
        } catch (ParseException e) {
            log.error("时间：{}转换格式：{}异常：", dateString, format, e);
        }
        return retDate;
    }

    /**
     * getDate.
     */
    public static String getDate(String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(LocalDateTime.now());
    }

    /**
     * 获取时间差.
     *
     * @param date1 日期
     * @param date2 日期
     * @return
     */
    public static BigDecimal differentDaysByMillisecond(Date date1, Date date2) {
        BigDecimal diffTimes = new BigDecimal(date2.getTime()).subtract(new BigDecimal(date1.getTime()));
        return diffTimes.divide(new BigDecimal(DateUtil.ONE_DAY_MILLISENCONDS), 2, RoundingMode.HALF_UP);
    }

    /**
     * 给日期加天数.
     *
     * @param date 日期
     * @param day  天数 + 或 -
     * @return String
     */
    public static String addDate(String date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtil.string2date(date, DateUtil.DATE_YYYY_MM_DD));
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return DateUtil.date2String(calendar.getTime(), DateUtil.DATE_YYYY_MM_DD);
    }

    /**
     * 给日期加年数.
     *
     * @param date 日期
     * @param year 年数 + 或 -
     * @return Date
     */
    public static Date addYear(Date date, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, year);
        return calendar.getTime();
    }


    /**
     * 给日期加月份.
     *
     * @param date  日期
     * @param month 月份 + 或 -
     * @return Date
     */
    public static Date addMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    /**
     * 判断当前时间是否在微信支持时间9：00 - 17：00.
     *
     * @return
     */
    public static boolean isEffectiveTime9To17() {
        LocalTime now = LocalTime.now(WECHAT_CN_ZONE_ID);
        return !now.isBefore(WECHAT_SELFHELP_OPEN_TIME) && !now.isAfter(WECHAT_SELFHELP_FIVE_PM);
    }

    /**
     * 判断当前时间是否在微信支持时间9：00 - 21：00.
     *
     * @return
     */
    public static boolean isWeChatSelfHelpOpeningNow() {
        LocalTime now = LocalTime.now(WECHAT_CN_ZONE_ID);
        return !now.isBefore(WECHAT_SELFHELP_OPEN_TIME) && !now.isAfter(WECHAT_SELFHELP_CLOSE_TIME);
    }

    /**
     * localDate2Date.
     *
     * @param ldate ldate
     * @return
     */
    public static Date localDate2Date(LocalDate ldate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = ldate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * localDateTime2Date.
     *
     * @param localDateTime ldate
     * @return
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * date2LocalDate.
     *
     * @param date date
     * @return
     */
    public static LocalDate date2LocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }

    /**
     * date2LocalDateTime.
     *
     * @param date date
     * @return
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * localdatetimeToString.
     */
    public static String localdatetimeToString(LocalDateTime localDateTime, String format) {
        if (localDateTime == null || format == null) {
            return null;
        }
        return localDateTime.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * string2LocalDate.
     *
     * @param dateStr dateStr
     * @param format  format
     * @return
     */
    public static LocalDate string2LocalDate(String dateStr, String format) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(format));
    }

    /**
     * 功能描述:
     * 将LocalDateTime转化为指定格式的字符串时间.
     *
     * @methodname: localDateTime2String
     * @params: [time：待转化时间, format：转化格式]
     * @returns: java.lang.String
     * @author: somnus
     * @date: 2019-12-02 21:52:06
     */
    public static String localDateTime2String(LocalDateTime time, String format) {
        return DateTimeFormatter.ofPattern(format).format(time);
    }

    /**
     * localdateToString.
     */
    public static String localdateToString(LocalDate localDate, String format) {
        if (localDate == null || format == null) {
            return null;
        }
        return localDate.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * string2LocalDateTime.
     *
     * @return
     */
    public static LocalDateTime string2LocalDateTime(String timeStr, String format) {
        DateTimeFormatter timeDtf = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(timeStr, timeDtf);
    }


}
