package com.hang.Time;

import java.util.TimeZone;

/**
 * @author: hangshuo
 * @date: 2022/01/20 18:45
 * @Description:
 * Calendar 和 Date 相比，它提供了时区转换的功能，时区用TimeZone对象表示
 * PS：时区的唯一标识是以字符串表示的ID，我们获取指定TimeZone对象也是以这个ID为参数获取，GMT+09:00、Asia/Shanghai都是有效的时区ID。
 *      要列出系统支持的所有ID，请使用TimeZone.getAvailableIDs()。
 *
 */

public class TimeZoneTest01 {
    public static void main(String[] args) {
        TimeZone tzDefault = TimeZone.getDefault(); // 当前时区
        TimeZone tzGMT9 = TimeZone.getTimeZone("GMT+09:00"); // GMT+9:00时区
        TimeZone tzNY = TimeZone.getTimeZone("America/New_York"); // 纽约时区
        System.out.println(tzDefault.getID()); // Asia/Shanghai
        System.out.println(tzGMT9.getID()); // GMT+09:00
        System.out.println(tzNY.getID()); // America/New_York
    }
}
