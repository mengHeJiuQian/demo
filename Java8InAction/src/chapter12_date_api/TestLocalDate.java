package chapter12_date_api;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TestLocalDate {

    @Test
    public void testLocalDate() {
        LocalDate date = LocalDate.of(2014, 3, 18);
        boolean leapYear = date.isLeapYear();

        int year = date.get(ChronoField.YEAR);
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);

        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getMonthValue());
        System.out.println(date.getDayOfMonth());

        LocalDateTime localDateTime = date.atTime(LocalTime.now());

        // Instant
        Instant instant1 = Instant.ofEpochSecond(3);
        Instant instant2 = Instant.ofEpochSecond(3, 5);
        System.out.println(instant1.toString());
        System.out.println(instant2.toString());

        // Duration或Period Duration主要用于秒和纳秒，Period主要用于年、月、日的时间建模。
        Duration threeMinutes1 = Duration.ofMinutes(3);
        Duration threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);

        Period tenDays = Period.ofDays(10);
        Period twoYearsSixMonthsOneDay = Period.of(2,6,1);

        //操作、解析和格式化日期
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        date1.withYear(2011);

        // 使用TemporalAdjuster进行日期的负责计算

        LocalDate date10 = LocalDate.of(2020, 10 , 21);
        LocalDate with = date10.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        System.out.println(with);



    }

}
