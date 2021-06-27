package com.hang.collectionDemo.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test01 {
    public static void main(String[] args) {
        List<Integer> list0 = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i<10;i++){
            list0.add(random.nextInt(100));
        }
        System.out.println(list0);//[46, 7, 91, 48, 52, 25, 64, 3, 28, 60]
        /*
         * 对集合进行自然排序，从小到大
         */
        Collections.sort(list0);
        System.out.println(list0);//[2, 19, 44, 46, 61, 67, 68, 89, 91, 94]

        List<String> list1 = new ArrayList<>();
        list1.add("Alive");
        list1.add("Rose");
        list1.add("Jack");
        list1.add("Noname");
        System.out.println(list1);//[Alive, Rose, Jack, Noname]
        Collections.sort(list1);
        /*
         *对集合进行自然排序，显而易见是按照首字母顺序排序
         */
        System.out.println(list1);//[Alive, Jack, Noname, Rose]
    }
}


