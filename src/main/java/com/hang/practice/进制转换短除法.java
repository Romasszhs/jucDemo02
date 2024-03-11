package com.hang.practice;

import java.util.Scanner;

/**
 * 十进制转八进制  只有十进制转换为小的进制时可以使用该方法。
 * @author: hangshuo
 * @date: 2023/12/28 10:10
 * @Description:
 */

public class 进制转换短除法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int yu = 0;
        StringBuilder sb = new StringBuilder();
        while (i>=8){ //循环计算
            yu = i%8;
            i = i/8;
            sb.append(String.valueOf(yu));
        }
        if(i<8){ // 别忘记最后一位
            i = i % 8;
            sb.append(String.valueOf(i));
        }
        System.out.println(sb.reverse().toString());// 反转输出
    }

}
