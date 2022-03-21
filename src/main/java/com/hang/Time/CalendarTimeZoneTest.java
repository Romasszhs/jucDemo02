package com.hang.Time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: hangshuo
 * @date: 2022/01/20 19:05
 * @Description:
 *
 */

public class CalendarTimeZoneTest {
    public static void main(String[] args) {
        // 当前时间：
        System.out.println(System.currentTimeMillis());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd,yyyy");
        System.out.println(sdf.format(date));
        

    }
}
