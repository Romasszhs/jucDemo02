package com.hang.collectionDemo.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class test05 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i=0;
        while (i<6){
            list.add(String.valueOf(i));
            System.out.println(list);
            i++;
        }
        // 使用Iterator方式
        // 正例
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String item  = iterator.next();
            if ("1".equals(item)){
                iterator.remove();
            }
        }
        System.out.println(list);

        //int a = Integer.parseInt(null);
        Integer b = null;
        System.out.println(b);
        //System.out.println(a);

    }
}
