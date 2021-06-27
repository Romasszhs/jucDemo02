package com.hang.collectionDemo.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class demo01 {
    public static void main(String[] args) {
        ArrayList<Integer> lists = new ArrayList<>();

        // Array 可以存储基本数据类型和对象，ArrayList 只能存储对象。
        //ArrayList<boolean> list = new ArrayList<>();


        lists.add(1000);
        lists.add(1200);
        lists.add(1400);
        lists.forEach(System.out::println);

        System.out.println(lists.get(0).equals(1000));
        Integer next ;
        Iterator<Integer> iterator = lists.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            System.out.println(next);
        }
    }
}
