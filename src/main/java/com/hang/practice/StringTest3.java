package com.hang.practice;

/**
 * @author: hangshuo
 * @date: 2021/05/08 13:04
 * @Description:
 */

/*
* 做加法表达式时
* 三个小口诀：
* 1.常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
* 2.只要其中一个是变量，结果就在堆中。
* 3.如果拼接的结果调用intern()方法，返回值就在常量池中
*
* */
public class StringTest3 {

    public static void main(String[] args) {
        String str1 = "123"+"AAA";// 这一步直接在常量池中运算，结果也是常量池中的对象，所以str1指向常量池中的对象
        String str2 = "123";
        String str3 = "AAA";
        String str4 = str2+str3; // 这一步需要在堆中新建对象，所以str4指向堆中的对象
        // 由于赋值语句右侧使用的不同类型常量赋值，因此会使用StringBuilder实现字符串拼接
        // 会先调用其append方法最后调用toString方法，而toString方法是new String并返回，即在堆中创建对象
        // 所以str4和str6的值需要在运行时确认
        // jad工具反编译后
        //         String str4 = (new StringBuilder()).append(str2).append(str3).toString();
        //        String str6 = (new StringBuilder()).append(str2).append(2).toString();
        String str6 = str2+2;
        final String str7 = "123";
        String str8 = str7+2;
        // 由于str7是常量所以编译期，编译器会直接将str7替换为其值，并直接拼接成"1232"赋值给str8，这又叫做“常量传播”优化
        // 在编译期就能确定str7和str8的值
        //        String str7 = "123";
        //        String str8 = "1232";
        System.out.println(str6==str7);// false

        System.out.println(str1==str4);// false

        String str5 = str1.intern();
        System.out.println(str1 == str5);// true
        System.out.println(str4 == str5);// false


    }
}
