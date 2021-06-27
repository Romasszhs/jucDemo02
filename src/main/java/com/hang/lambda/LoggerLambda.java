package com.hang.lambda;

/**
 * @author: hangshuo
 * @date: 2021/04/15 18:58
 * @Description:
 */

public class LoggerLambda {
    public static void log(int level, MessageBuilder builder){
        if (level==1) {
            System.out.println(builder.buildMessage());
        }
    }

    public static void main(String[] args) {
        String msgA = "HELLO";
        String msgB = "WORLD";

        log(1,()->(msgA+msgB));
    }
}
