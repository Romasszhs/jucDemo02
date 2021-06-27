package com.hang.lambda;

/**
 * @author: hangshuo
 * @date: 2021/05/10 15:53
 * @Description:
 */

public interface MessageBuilder2 {
    public default void  method(){
        System.out.println("默认方法");
    }
}
