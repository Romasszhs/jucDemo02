package com.hang.practice;

import java.util.Scanner;

/**
 * @author: hangshuo
 * @date: 2021/05/11 15:01
 * @Description:
 */

// 尾递归优化，但不是所有算法都能写成尾递归
// 每次调用函数时不生成新的运行栈，利用上一次的结果
public class FibonacciTest2 {
    private static int fibo(int n,int accumulator,int calculator){
        if (n==1) return accumulator;
        if (n==2) return calculator;
        return fibo(n-1, calculator, accumulator+calculator);
    }

    public static void main(String[] args) {
        System.out.println(fibo(30, 1, 1));
//        try (Scanner scanner = new Scanner(System.in)){
//
//        }
    }
}
