package com.hang.juc.stream;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author: hangshuo
 * @date: 2021/11/05 16:20
 * @Description:
 */

public class reduceTest {
    static long a = 0;
    static long b = 1;


    public static void main(String[] args) {

        Integer reduce = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(1, (acc, item) -> {
            return acc + item   ;
        });

        System.out.println(reduce);

        LongStream stream1 = LongStream.generate(() -> {
            long tmp = a;
            a = b;
            b += tmp;
            return b;
        });
        LongStream stream2 = LongStream.generate(() -> {
            long tmp = a;
            a = b;
            b += tmp;
            return b;
        });;

//        stream1.limit(10).forEach(System.out::println);
        long[] longs = stream1.limit(10).toArray();

        for (long l : longs) {
            System.out.print(l+" ");
        }

        System.out.println("\n--------------------");

        Stream<Long> boxed = stream2.limit(10).boxed();
//        System.out.println(boxed.count());
        List<Long> collect = boxed
                .collect(Collectors.toList());
        System.out.println(collect);

        List<String> list = Lists.newArrayList("Apple", "Banana", "Orange");

        String[] strings = list.stream().toArray(String[]::new);

        for (String string : strings) {
            System.out.print(string + "\t");
        }
        System.out.println("\n--------------------");

        HashMap<Object, Object> objectObjectHashMap = Maps.newHashMap();


    }
}
