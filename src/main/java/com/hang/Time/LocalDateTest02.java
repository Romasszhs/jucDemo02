package com.hang.Time;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author: hangshuo
 * @date: 2021/06/26 17:52
 * @Description:
 */

public class LocalDateTest02 {
    public static void main(String[] args) {
        testZonedDateTime();
    }

    public static void testZonedDateTime(){
        // 获取当前时间日期
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);


    }
}
