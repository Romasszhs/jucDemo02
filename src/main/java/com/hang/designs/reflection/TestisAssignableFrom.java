package com.hang.designs.reflection;

/**
 * @author: hangshuo
 * @date: 2021/05/04 17:08
 * @Description:
 */

public class TestisAssignableFrom {
    public static void main(String[] args) {
        String str = "123";

        System.out.println(String.class.isAssignableFrom(String.class));// true
        /*
        * Java中isAssignableFrom的用法
        * class1.isAssignableFrom(class2)
        * 判定此 Class 对象所表示的类或接口与指定的 Class 参数所表示的类或接口是否相同，或是否是其超类或超接口。
        * 如果是则返回 true；否则返回 false。
        * 如果该 Class 表示一个基本类型，且指定的 Class 参数正是该 Class 对象，则该方法返回 true；否则返回 false。
        * */

        /*
        * String类实现了CharSequence接口
        * */
        System.out.println(String.class.isAssignableFrom(CharSequence.class)); // false

    }
}
