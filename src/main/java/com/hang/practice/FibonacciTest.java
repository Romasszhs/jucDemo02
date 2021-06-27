package com.hang.practice;

import java.util.Scanner;

/**
 * @author: hangshuo
 * @date: 2021/05/07 1:48
 * @Description:
 */

public class FibonacciTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        Integer integer = Integer.valueOf(next);
        System.out.println(integer);
        int fibo = fibo(integer);
        System.out.println(fibo);
    }

    public static int fibo(int n){
//        if (n==0){
//            return 0;
//        }
        if (n==1||n==2){
            return 1;
        }

        return fibo(n-1)+fibo(n-2);
    }
}
