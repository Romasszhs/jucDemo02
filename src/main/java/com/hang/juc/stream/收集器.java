package com.hang.juc.stream;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: hangshuo
 * @date: 2021/06/11 13:49
 * @Description:
 */

public class 收集器 {


    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"xixi","男"));
        persons.add(new Person(2,"haha","女"));
        persons.add(new Person(3,"xiuxiu","女"));
        persons.add(new Person(4,"wyuwy","男"));


        Map<Boolean, List<Person>> map = persons.stream().collect(Collectors.partitioningBy(u -> u.getGender().equals("男")));
        System.out.println(map);

        List<Person> persons2 = new ArrayList<>();
        persons2.add(new Person(2,"haha","女"));
        persons2.add(new Person(1,"xixi","男"));
        persons2.add(new Person(3,"xiuxiu","女"));
        persons2.add(new Person(4,"wyuwy","男"));

        IntSummaryStatistics idStatistics = persons2.stream().collect(Collectors.summarizingInt(Person::getId));
        System.out.println(idStatistics);

        Object[] objects = Stream.of(1, 22, 3, 1, 2, 4, 5, 6, 10).toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
    }
}
