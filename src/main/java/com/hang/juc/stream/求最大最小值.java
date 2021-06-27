package com.hang.juc.stream;

import java.util.Comparator;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author: hangshuo
 * @date: 2021/06/11 13:27
 * @Description:
 */

public class 求最大最小值 {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> min = integerStream.min(Comparator.comparingInt(i -> i));
        System.out.println(min.get());

        /*Optional<Integer> max = integerStream.max(Comparator.comparingInt(i -> i));
        System.out.println(max);*/

        new Random().ints().limit(50).parallel().forEach(i->{
            System.out.println(Thread.currentThread().getName()+"------"+i);
        });

    }
}
