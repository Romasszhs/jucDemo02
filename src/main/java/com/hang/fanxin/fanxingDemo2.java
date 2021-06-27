package com.hang.fanxin;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: hangshuo
 * @date: 2021/05/07 17:19
 * @Description:
 */

public class fanxingDemo2 {
    public static void main(String[] args) throws Exception{

        List<String> list2 = new ArrayList<String>();
        list2.add("123");


        List<Integer> list = new ArrayList<Integer>();

        list.add(12);

        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        add.invoke(list,"STR");

        System.out.println("list:"+list);// [12, STR]


        /*
        * list 和 list2 由于泛型类型的原因,字节码文件确实是不同的,注意字节码文件影响的是在栈中的操作
        * 类型检查就是针对引用的，谁是一个引用，用这个引用调用泛型方法，就会对这个引用调用的方法进行类型检测，在该调用者中会对类型获取的地方进行隐形类型强转
        * String s = list2.get(0);反编译class字节码文件后，String s = (String) list2.get(0);
        * 但是加载到内存方法区中的的 ArrayList的class类 确实是唯一一个
        * ArrayList的class类会进行类型擦除，变成原始类型Object，所以通过反射可以做到添加泛型限制以外的类型
        * 本例是将String类型添加到泛型限制为Integer的ArrayList对象中。
        * */
        System.out.println(list.getClass() == list2.getClass() ); // true

        String s = list2.get(0);

        Integer integer = list.get(0);

        // 抛出异常 Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
        //Integer integer1 = list.get(1);

        System.out.println(list.get(1).getClass());

    }
}
