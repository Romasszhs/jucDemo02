package com.hang.Time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @author: hangshuo
 * @date: 2022/02/10 17:32
 * @Description:
 */

public class LocalDateTimeTest01 {
    public static void main(String[] args) {
        LocalDate d = LocalDate.now(); // 当前日期
        LocalTime t = LocalTime.now(); // 当前时间
        LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
        System.out.println(d); // 严格按照ISO 8601格式打印
        System.out.println(t); // 严格按照ISO 8601格式打印
        System.out.println(dt); // 严格按照ISO 8601格式打印

        // 输出某个月第一个周日这样的问题
        LocalDateTime of = LocalDateTime.of(2022, 1, 1, 10, 0);
        LocalDateTime of2 = of.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
        System.out.println(of);
        System.out.println(of2);

        LocalDateTime dt1 = LocalDateTime.of(2022,1,1,12,4,1);
        System.out.println(dt1);
        System.out.println(dt1.withDayOfMonth(5));

        LocalDateTime firstDay = LocalDate.of(2020, 8, 1).atStartOfDay();
        System.out.println(firstDay);


    }
}
