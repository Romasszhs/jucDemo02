package com.hang.practice.algorithm;

import com.google.common.collect.Lists;
import com.google.errorprone.annotations.Var;

import java.util.List;

/**
 * @author: hangshuo
 * @date: 2021/11/28 17:34
 * @Description:
 */

public class fibo {

    public static void main(String[] args) {
        System.out.println(fibotest(5));
    }

    public static int  fibotest(int num){
        if (num == 1 || num == 2){
            return 1;
        }
        return fibotest(num-1)+ fibotest(num-2);
    }
}
