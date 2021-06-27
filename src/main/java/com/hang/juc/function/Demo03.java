package com.hang.juc.function;


import java.util.function.Consumer;

//  Consumer 消费型接口 只有输入，没有返回值
public class Demo03 {
    public static void main(String[] args) {
        Consumer<String> consumer = (str)->{
            System.out.println(str);
        };

        consumer.accept("ABCV");
    }
}
