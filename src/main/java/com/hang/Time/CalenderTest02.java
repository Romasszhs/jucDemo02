package com.hang.Time;

import java.util.Calendar;
import java.util.Date;

/**
 * @author: hangshuo
 * @date: 2022/01/20 18:40
 * @Description:
 */

public class CalenderTest02 {
    public static void main(String[] args) {
        Date date = new Date();

        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getTime());
        System.out.println(date);
    }
}
