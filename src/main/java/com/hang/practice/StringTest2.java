package com.hang.practice;

/**
 * @author: hangshuo
 * @date: 2021/05/07 21:14
 * @Description:
 */

public class StringTest2 {
    public static void main(String[] args) {
        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println(str1==str2);// false
        str1 = str2.intern();
        System.out.println(str1);
        System.out.println(str1==str2);// false

        str2 = str1.intern();
        System.out.println(str1==str2);// true

        String intern1 = "zhangsan".intern(); // intern方法返回对象地址，intern1指向字符串常量池中的对象
        System.out.println(intern1);

        String intern2 = new String("zhangsan");// 指向堆中的对象
        System.out.println(intern1==intern2);// false  所以引用地址并不相同

        String intern3 = "zhangsan";// 指向字符串常量池中的已经存在的对象
        System.out.println(intern1==intern3); // true
    }
}
