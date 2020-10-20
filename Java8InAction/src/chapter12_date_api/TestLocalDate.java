package chapter12_date_api;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestLocalDate {

    @Test
    public void testLocalDate() {
        LocalDate date = LocalDate.of(2014, 3, 18);
        boolean leapYear = date.isLeapYear();
    }
}
