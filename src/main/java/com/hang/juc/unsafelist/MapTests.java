package com.hang.juc.unsafelist;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MapTests {
    public static void main(String[] args) {
        //map怎么用？ 默认等价于什么？？不是，工作中不用HashMap
        //加载因子，初始化容量?  new HashMap<>(16,0.75);
        Map<String,String> map = new HashMap<String,String>(16, (float) 0.75);

        Map<String,String> map3 = Collections.synchronizedMap(new HashMap<>());
        //解决Map不安全的方式  java.util.ConcurrentModificationException
        // 1. Collections.synchronizedMap(new HashMap<>())
        // 2. new ConcurrentHashMap<>()
        Map<String,String> map2 = new ConcurrentHashMap<>();
        for (int i = 0; i < 15; i++) {
            new Thread(()->{
                map2.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
                System.out.println(map2);
            },String.valueOf(i)).start();
        }
    }
}
