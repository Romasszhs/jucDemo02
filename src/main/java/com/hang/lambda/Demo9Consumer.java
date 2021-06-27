package com.hang.lambda;

import java.util.function.Consumer;

/**
 * @author: hangshuo
 * @date: 2021/04/16 0:34
 * @Description:
 */

public class Demo9Consumer {
    public static void consumerString (Consumer<String> consumer){
        consumer.accept("HELLO");

    }


    public static void main(String[] args) {
        consumerString(s-> System.out.println(s));
        consumerString(System.out::println);
    }
}
