package com.hang.lambda;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: hangshuo
 * @date: 2021/04/16 19:49
 * @Description:
 */

public class Demo12Stream {
    public static void main(String[] args) {
        ArrayList<String> one = Lists.newArrayList();
        one.add("迪丽热巴");
        one.add("张三");
        one.add("李四");
        one.add("王五");
        one.add("赵六");
        one.add("张琳");

        ArrayList<String> two = Lists.newArrayList();
        two.add("迪丽热巴");
        two.add("张三");
        two.add("李四四");
        two.add("王五六");
        two.add("赵六");
        two.add("张琳");

        Stream<String> streamOne = one.stream()
                .filter(s -> s.length() == 2)
                .skip(2)
                .limit(2);

        Stream<String> streamTwo = two.stream().filter(s -> s.startsWith("王"));
        // List<String> list = streamTwo.collect(Collectors.toList());
        // list.forEach(System.out::println);
        // streamTwo = two.stream().filter(s -> s.startsWith("张") || s.startsWith("李"));
        System.out.println("============");
        Stream<String> streamThree = Stream.concat(streamOne, streamTwo);

        streamThree.map(Person::new).forEach(System.out::println);
        // System.out是对象名，方法引用通过对象名引用成员方法
    }
}
