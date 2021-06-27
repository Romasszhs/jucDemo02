package com.hang.fanxin;

import java.util.ArrayList;

/**
 * @author: hangshuo
 * @date: 2021/05/07 18:16
 * @Description:
 */
/*
* 通过下面的例子，我们可以明白，类型检查就是针对引用的，谁是一个引用，用这个引用调用泛型方法，就会对这个引用调用的方法进行类型检测，
* 而无关它真正引用的对象。
 * */
public class fanxingDemo3 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList();
        list1.add("1"); //编译通过
        //list1.add(1); //编译错误
        String str1 = list1.get(0); //返回类型就是String

        ArrayList list2 = new ArrayList<String>();
        list2.add("1"); //编译通过
        list2.add(1); //编译通过
        Object object = list2.get(0); //返回类型就是Object
        Object o = list2.get(1);

        new ArrayList<String>().add("11"); //编译通过
        //new ArrayList<String>().add(22); //编译错误

        String str2 = new ArrayList<String>().get(0); //返回类型就是String
    }
}
