package com.hang.lambda;

import java.util.function.Function;

/**
 * @author: hangshuo
 * @date: 2021/04/16 0:56
 * @Description:
 */

public class Demo10Function {

    public static void testFuntion(Function<String,Integer> function){
        Integer num = function.apply("10");
        System.out.println("10转化为Int类型的基本类型"+num);
    }

    public static void main(String[] args) {
        testFuntion(s->Integer.parseInt(s));
    }
}
