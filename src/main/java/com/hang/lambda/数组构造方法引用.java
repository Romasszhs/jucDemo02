package com.hang.lambda;

import java.util.function.Function;
import java.util.function.IntFunction;

/**
 * @author: hangshuo
 * @date: 2021/06/11 14:48
 * @Description:
 */

public class 数组构造方法引用 {
    public static void main(String[] args) {
        Function<Integer,int[]> func = (i)->new int[i];
        int[] arr = func.apply(10);
        System.out.println("arr.length:"+arr.length);

        IntFunction<int[]> func2 = int[]::new;
        int[] arr2 = func2.apply(5);
        System.out.println("arr2.length:"+arr2.length);
    }
}
