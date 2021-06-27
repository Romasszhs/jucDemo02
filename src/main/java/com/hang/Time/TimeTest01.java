package com.hang.Time;

import java.util.Date;
import java.util.Locale;

/**
 * @author: hangshuo
 * @date: 2021/06/25 17:09
 * @Description:
 */

public class TimeTest01 {
    public static void main(String[] args) {
        Date date = new Date();

        System.out.println(date.toInstant());// UTC 0 时区  ，东八区加八小时
        System.out.println(date.toString());


        System.out.printf("全部日期和时间信息：%tc%n",date);

        String str=String.format(Locale.US,"英文星期的简称：%ta",date);
        System.out.println(str);

        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);

        //R的使用
        System.out.printf("HH:MM格式（24时制）：%tR",date);
    }
}
