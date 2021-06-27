package com.hang.lambda;

import java.util.function.Function;

/**
 * @author: hangshuo
 * @date: 2021/04/16 1:00
 * @Description:
 */

public class Demo11Function {
    public static void testFuntion(Function<String,Integer> function1,Function<Integer,Integer> function2){
        Integer num = function1.andThen(function2).apply("10");
        System.out.println("经过两次FunctionApply的数值为:"+(num+20));
    }

    public static void main(String[] args) {
        testFuntion(s->Integer.parseInt(s),integer -> integer  *= 10);
    }
}
