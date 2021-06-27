package com.hang.collectionDemo.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class array2list {
    public static void main(String[] args) {
        int[] is = {1,2,3,4};
        List list = Arrays.asList(is);
        System.out.println(list.getClass().getName());//不是java.util.List
        // 输出： java.util.Arrays$ArrayList 即该对象是Arrays的内部类对象
        // 所以不能使用其修改集合相关的方法。

        // 方式一 ： 将数组转换为ArrayList
        Integer[] i = {1,2,3,4};
        List myList = new ArrayList<>(Arrays.asList(i));
        System.out.println(myList.getClass().getName());//java.util.ArrayList

        // 方式二 ： 将包装类的数组转换为List
        Integer [] myArray = { 1, 2, 3 };
        List myList2 = Arrays.stream(myArray).collect(Collectors.toList());
        System.out.println(myList2.getClass().getName());//java.util.ArrayList

        // 方式三 ： 基本类型也可以实现转换（依赖boxed的装箱操作）
        int [] myArray2 = { 1, 2, 3 };
        List myList3 = Arrays.stream(myArray2).boxed().collect(Collectors.toList());
        System.out.println(myList3.getClass().getName());
    }
}
