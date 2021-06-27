package com.hang.juc.function;

import java.util.function.Function;

/*
* java.util.function 包
* Function 函数式接口
* 接收一个参数  T ，返回一个值 R
*
* */
public class Demo01 {
    public static void main(String[] args) {
        Function function = new Function<String,String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };

        System.out.println(function.apply("zhangsan"));

        // 使用Lambda表达式进行简化
        Function function1 = (str)->{

            return str;
        };

        System.out.println(function1.apply("lisi"));
    }
}
