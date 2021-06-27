package com.hang.collectionDemo.collection;

import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author: hangshuo
 * @date: 2021/04/25 23:30
 * @Description:
 */

public class mapTest {
    public static void main(String[] args) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("1","123");
        map.put("2","456");

        Set<Map.Entry<String, Object>> entries = map.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        System.out.println(iterator.next().getKey());
        System.out.println(iterator.next().getValue());

        for (Map.Entry<String, Object> stringObjectEntry : map.entrySet()) {
            System.out.println(stringObjectEntry.getKey() +"  "+ stringObjectEntry.getValue());

        }

        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
