package com.hang.collectionDemo.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hangshuo
 * @date: 2021/04/26 0:07
 * @Description:
 */

public class fanxinTest2 {

    public static void main(String[] args) {
        List<String> generics = null;
        List notGenerics = new ArrayList(10);
        notGenerics.add(new Object());
        notGenerics.add(new Integer(1));
        generics = notGenerics;
        // 此处抛出 ClassCastException 异常
        // String string = generics.get(0);

        if (generics.get(0) instanceof String) {
            String s  = (String)generics.get(0);
            System.out.println(s);
        }
    }
}
