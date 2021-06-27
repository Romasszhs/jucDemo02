package com.hang.collectionDemo.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class arrayreverse {
    public static void main(String[] args) {
        // 本例实践数组反转，由数组到集合再到数组。
        String[] s = new String[]{
                "dog", "cat", "bird",null
        };
        List<String> list = Arrays.asList(s);
        Collections.reverse(list);
        // 集合转数组的方法，必须使用集合的toArray(T[] array)，传入的是类型完全一致、长度为0的空数组
        s = list.toArray(new String[0]);
        for (String s1 : s) {
            System.out.println(s1);
        }



    }
}
