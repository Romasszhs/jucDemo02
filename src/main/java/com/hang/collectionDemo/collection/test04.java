package com.hang.collectionDemo.collection;

import java.util.ArrayList;
import java.util.List;

//不要在 foreach 循环里进行元素的 remove/add 操作。remove 元素请使用 Iterator
//方式，如果并发操作，需要对 Iterator 对象加锁。
public class test04 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i=0;
        while (i<6){
            list.add(String.valueOf(i));
            System.out.println(list);
            i++;
        }
        // 单线程下不要在foreach循环里进行元素的remove/add操作，remove元素请使用Iterator方式，
        // 如果并发操作，需要对Iterator对象加锁。
        // 反例
        for (String s : list) {
            if ("5".equals(s)){
                list.remove(s);

            }
        }
        //fail-fast 机制 ：多个线程对 fail-fast 集合进行修改的时，可能会抛出ConcurrentModificationException，单线程下也会出现这种情况

    }
}
