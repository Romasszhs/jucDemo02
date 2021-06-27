package com.hang.collectionDemo.collection;

import java.util.TreeSet;

/**
 * @author: hangshuo
 * @date: 2021/05/15 11:04
 * @Description:
 */

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("100");
        set.add("z");
        set.add("12");
        set.add("z10");

        System.out.println(set.last());


    }
}
