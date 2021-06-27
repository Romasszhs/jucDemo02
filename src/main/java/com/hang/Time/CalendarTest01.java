package com.hang.Time;

import java.time.LocalDate;
import java.util.*;

/**
 * @author: hangshuo
 * @date: 2021/06/26 15:18
 * @Description:
 */

public class CalendarTest01 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.MONTH));
        c.set(Calendar.DATE,10);
        System.out.println(c);

        c.set(1,1);
        System.out.println(c);
        System.out.println(c.get(Calendar.YEAR)+" "+c.get(Calendar.MONTH)+" "+c.get(Calendar.DATE));

        // Calendar类实现了公历日历，GregorianCalendar是Calendar类的一个具体实现。
        // Calendar 的getInstance（）方法返回一个默认用当前的语言环境和时区初始化的GregorianCalendar对象。
        // GregorianCalendar定义了两个字段：AD和BC。这是代表公历定义的两个时代。
        GregorianCalendar gcalendar = new GregorianCalendar();
        GregorianCalendar gcalendar2 = new GregorianCalendar(Locale.CHINA);
//        GregorianCalendar gcalendar3 = new GregorianCalendar(TimeZone.getTimeZone("8"));
        LocalDate DATELOCAL = LocalDate.of(gcalendar2.get(Calendar.YEAR),
                gcalendar2.get(Calendar.MONTH) + 1,
                gcalendar2.get(Calendar.DAY_OF_MONTH));
        System.out.println(DATELOCAL);


        int year ;
        System.out.println(year=gcalendar.get(Calendar.YEAR));
        System.out.println(gcalendar.get(Calendar.MONTH));// Calender的月份是从0开始的，但日期和年份是从1开始的
        System.out.println(gcalendar.get(Calendar.DATE));


        // 测试当前年份是否为闰年
        if(gcalendar.isLeapYear(year+3)) {
            System.out.println("当前年份是闰年");
        }
        else {
            System.out.println("当前年份不是闰年");
        }

        // Date类转LocalDate类
        System.out.println("-------------------Date类转LocalDate类-------------------");
        Date input = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(input);
        LocalDate date = LocalDate.of(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(date);


        Date input2 = new Date();
        Calendar cal2 = Calendar.getInstance();
        cal.setTime(input2);
        System.out.println(cal2.getInstance());
        System.out.println(cal2.toInstant());


    }
}
