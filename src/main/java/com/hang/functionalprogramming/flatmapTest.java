package com.hang.functionalprogramming;

import com.beust.jcommander.internal.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author: hangshuo
 * @date: 2022/02/23 15:24
 * @Description:
 */

public class flatmapTest {
    public static void main(String[] args) {
        Stream<List<Integer>> s = Stream.of(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9));

        List<String> ab = Lists.newArrayList("1", "ab", "56");
        Stream<String> stream = ab.stream();
        String[] strarrays = new String[]{"1a1","2cc2"};
        String[] strArr = {"abc","cdd","kpp"};
        Arrays.stream(strarrays).forEach(System.out::println);

        List<Integer> cd = Lists.newArrayList(1, 2, 3, 4, 5);
        Stream<Integer> stream1 = cd.stream();
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5);
        Stream<Integer> integerStream1 = s.flatMap(list -> Stream.of(list.get(0)));
        integerStream1.forEach(System.out::println);

        Stream<List<Integer>> stream2 = Stream.of(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9));
        Stream<Integer> integerStream2 = stream2.flatMap(list -> list.stream());
        integerStream2.forEach(System.out::println);
    }
}
