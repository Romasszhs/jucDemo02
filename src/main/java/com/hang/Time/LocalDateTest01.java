package com.hang.Time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * @author: hangshuo
 * @date: 2021/06/26 16:16
 * @Description:
 */

public class LocalDateTest01 {
    public static void main(String[] args) {
        LocalDateTest01 localDateTest01 = new LocalDateTest01();
        localDateTest01.testLocalDateTime();
    }

    public void testLocalDateTime(){
        LocalDateTime currentTime = LocalDateTime.now();

        System.out.println("当前时间："+ currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1:"+ date1 );

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();
        System.out.println("月: " + month +", 日: " + day +", 秒: " + seconds);

        LocalDateTime date2 = currentTime.withMonth(1);
        System.out.println(date2);

        LocalDate date3 = LocalDate.of(2018, Month.JANUARY, 1);
        System.out.println(date3);

        LocalTime date4 = LocalTime.of(16, 59, 59);
        System.out.println(date4);

        // 解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
    }
}
