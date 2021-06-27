package com.hang.practice;

/**
 * @author: hangshuo
 * @date: 2021/05/07 21:07
 * @Description:
 */

public class StringTest1 {

    public static void main(String[] args) {
        String str1 = "hello";


        String intern = str1.intern();

        String str2 = str1.intern();


        System.out.println(intern);

        System.out.println(str1==str2);
    }
}
