package com.hang.collectionDemo.collection;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author: hangshuo
 * @date: 2021/05/14 19:44
 * @Description:
 */

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<String,String>  map = new TreeMap<>();
        map.put("1","张三");
        map.put("4","张三");
        map.put("3","张三");
        map.put("2","张三");
        map.put("100","王五");
        map.put("z","李丽");

        System.out.println(map.lastKey());
        System.out.println(map.pollLastEntry());
        System.out.println(map.size());

        HashMap<String ,String> hashMap = new HashMap<>();
        hashMap.put("1","李四");
        hashMap.put("2","李四");
        hashMap.put("3","李四");
    }
}
