package com.hang.juc.unsafelist;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetTest {
    public static void main(String[] args) {
        //java.util.ConcurrentModificationException 并发修改异常
        //Set<String> set = new LinkedHashSet<>();
        //报错

        Set<String> set = new HashSet<>();
        //报错

        //Set<String> set = Collections.synchronizedSet(new HashSet<>());
        //Set<String> set = new  CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
