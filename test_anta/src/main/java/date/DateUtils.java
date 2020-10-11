package date;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    private static final String UTC_STR = "yyyy-MM-dd'T'HH:mm:ss.SSS Z";
    private static final String SIMPLE_STR = "yyyy-MM-dd HH:mm:ss";
    private static final SimpleDateFormat UTC_DATE_FORMAT = new SimpleDateFormat(UTC_STR);
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(SIMPLE_STR);

    public static Date parse(final String date, final String pattern) {
        try {
            return new SimpleDateFormat(pattern).parse(date);
        } catch (final ParseException e) {
            return null;
        }
    }

    public static void main(final String[] args) {
        final String s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(dateEnd(new Date()));
        System.out.println("@@@@@@DateUtils.main():" + s);
    }

    public static Date dateStart(final Date date) {
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 比较两个时间的差
     *
     * @param startDate
     *            开始时间
     * @param endDate
     *            结束时间
     * @return
     */
    public static String compareDate(final Date startDate, final Date endDate) {
        if (startDate == null || endDate == null) {
            return "";
        }

        StringBuffer date = new StringBuffer();
        long time = Math.abs(endDate.getTime() - startDate.getTime());
        final int hour = (int) (time / (1000 * 3600));
        if (hour > 0 || date.length() > 0) {
            date = date.append(hour).append(" 时  ");
        }

        time = time - hour * 1000 * 3600;
        final int minute = (int) (time / (1000 * 60));
        if (minute > 0 || date.length() > 0) {
            date = date.append(minute).append(" 分 ");
        }

        time = time - minute * 1000 * 60;
        final int second = (int) (time / 1000);
        if (second > 0 || date.length() > 0) {
            date = date.append(second).append(" 秒 ");
        } else {
            date = date.append(0).append(" 秒 ");
        }
        // logger.debug("ExecuteDate:"+date.toString());
        return date.toString();
    }

    public static Date addMinute(final Date date, final int count) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, count);
        return cal.getTime();
    }

    public static Date addHour(final Date date, final int count) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, count);
        return cal.getTime();
    }

    /**
     * 取间隔若干天后的日期.
     *
     * @param date
     *            the date
     * @param count
     *            the day count
     * @return the Date
     */
    public static Date addDay(final Date date, final int count) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, count);
        return cal.getTime();

    }

    /**
     * 取间隔若干月后的日期.
     *
     * @param date
     *            the date
     * @param count
     *            the month count
     * @return the Date
     */
    public static Date addMonth(final Date date, final int count) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, count);
        return cal.getTime();

    }

    /**
     * 从字符串解析相对时间，得到绝对时间
     *
     * @param date
     *            参照时间
     * @param relativeDate
     *            相对时间字符串
     * @return 绝对时间
     */
    public static Date getRelativeDate(final Date date, String relativeDate) {
        if (null == relativeDate || "".equals(relativeDate)) {
            return null;
        }
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        relativeDate = relativeDate.trim();

        if (relativeDate.indexOf("月") != -1) {
            if (relativeDate.indexOf("号") != -1) {
                // 前1月,第5日
                final String[] tmp = relativeDate.replace("前", "").replace("月", "").replace("第", "").replace("号", "")
                        .split(",");
                final int month = Integer.parseInt(tmp[0].trim());
                int day = Integer.parseInt(tmp[1].trim());
                cal.add(Calendar.MONTH, -1 * month);
                // 如果day大于目标月份的最大天数，则day=最大天数
                final int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
                if (day > maxDay) {
                    day = maxDay;
                }
                cal.set(Calendar.DAY_OF_MONTH, day);

            } else {
                // 前若干月
                final int month = Integer.parseInt(relativeDate.replace("前", "").replace("月", "").trim());
                cal.add(Calendar.MONTH, -1 * month);
            }
        } else if (relativeDate.indexOf("天") != -1) {
            // 前若干天
            final int day = Integer.parseInt(relativeDate.replace("前", "").replace("天", "").trim());
            cal.add(Calendar.DAY_OF_MONTH, -1 * day);
        } else {
            // 前若干分钟
            cal.setTime(date);
            final int minute = Integer.parseInt(relativeDate.replace("前", "").replace("分钟", "").trim());
            cal.add(Calendar.MINUTE, -1 * minute);
        }

        return cal.getTime();
    }

    /**
     * 获取指定日期的最晚时间点，即当天的23:59:59:999
     *
     * @param date
     * @return
     */
    public static Date dateEnd(final Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 获取日期 yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static Date getDateTime(final String source) {
        final DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(source);
        } catch (final ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将字符串转换为Date yyyy-MM-dd
     *
     * @param source
     * @return
     */
    public static Date getDate(final String source) {
        final DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(source);
        } catch (final ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 转换Date为String yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String getString(final Date date) {
        if (date == null) {
            return null;
        }
        final DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * 转换Date为String yyyyMMdd
     *
     * @param date
     * @return
     */
    public static String getStringYMD(final Date date) {
        if (date == null) {
            return null;
        }
        final DateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(date);
    }

    /**
     * 转换Date为String yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String getStringDate(final Date date) {
        if (date == null) {
            return null;
        }
        final DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    /**
     * 转换Date为String yyyyMMddHHmmss
     *
     * @param date
     * @return
     */
    public static String getStringDateName(final Date date) {
        if (date == null) {
            return null;
        }
        final DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(date);
    }

    /**
     * 转换Date为String yyyyMMddHHmmssSSS
     *
     * @param date
     * @return
     */
    public static String getFullStringDate(final Date date) {
        if (date == null) {
            return null;
        }
        final DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return format.format(date);
    }

    public static Date utcParse(String str, String parrten) throws ParseException {
        Date date = utcDate(str);

        SimpleDateFormat simple = null;
        if(StringUtils.isEmpty(parrten)) {
            simple = SIMPLE_DATE_FORMAT;
        } else {
            simple = new SimpleDateFormat(parrten);
        }

        date = simple.parse(simple.format(date));

        return date;
    }

    public static String utcFormat(String str, String parrten) throws ParseException {
        Date date = utcDate(str);

        SimpleDateFormat simple = null;
        if(StringUtils.isEmpty(parrten)) {
            simple = SIMPLE_DATE_FORMAT;
        } else {
            simple = new SimpleDateFormat(parrten);
        }

        String format = simple.format(date);

        return format;
    }

    public static Date utcDate(String str) throws ParseException {
        if(StringUtils.isEmpty(str))
            return null;

        str = str.replace("Z", " UTC");
        Date date = UTC_DATE_FORMAT.parse(str);

        return date;
    }

    public static String utcCurrent(){
        return UTC_DATE_FORMAT.format(new Date());
    }
}

