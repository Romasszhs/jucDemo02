package com.hang.lambda;

/**
 * @author: hangshuo
 * @date: 2021/04/15 18:57
 * @Description:
 */

@FunctionalInterface
public interface MessageBuilder {
    String buildMessage();

    // 默认方法
    public default void method(){
        System.out.println("默认方法");
    }

    public static  void method1(){}


}
