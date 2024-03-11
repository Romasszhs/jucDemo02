package com.hang.practice;

import java.util.Scanner;

/**
 * @author: hangshuo
 * @date: 2023/12/27 17:57
 * @Description:
 */

public class 进制转换2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String number = in.nextLine();
            int i = Integer.parseInt(number.substring(2), 16);
            System.out.println("输入："+number+" 输出："+i);
        }
    }
}
