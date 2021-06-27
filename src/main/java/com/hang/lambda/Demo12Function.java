package com.hang.lambda;

import java.util.function.Function;

/**
 * @author: hangshuo
 * @date: 2021/04/16 1:15
 * @Description:
 */

public class Demo12Function {
    public static int getAgeNum(Function<String,String>function1 , Function<String,Integer> function2,Function<Integer,Integer> function3){
        Integer num = function1.andThen(function2).andThen(function3).apply("赵丽颖,20");


        return num;
    }

    public static void main(String[] args) {
        int ageNum = getAgeNum(s -> s.split(",")[1], i -> Integer.parseInt(i), i -> i += 100);
        System.out.println(ageNum);
    }
}
