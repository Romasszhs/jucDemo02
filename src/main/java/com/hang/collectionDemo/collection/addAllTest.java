package com.hang.collectionDemo.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: hangshuo
 * @date: 2021/04/25 23:18
 * @Description:
 */

public class addAllTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("123");
        list1.add("456");
        list1.add("234");

        list.addAll(list1);

        for (String s : list) {
            System.out.println(s);
        }


//        Collections.sort(list1);
//        for (String s : list1) {
//            System.out.println(s);
//        }
    }
}
