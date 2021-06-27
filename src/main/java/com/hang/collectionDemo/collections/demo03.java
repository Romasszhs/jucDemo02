package com.hang.collectionDemo.collections;

import java.util.TreeSet;

public class demo03 {
    /*
    * TreeSet 要求存放的对象所属的类必须实现 Comparable 接口，该接口提供了比较元素的 compareTo()方法，当插入元素时会回调该方法比较元素的大小。
    * TreeMap 要求存放的键值对映射的键必须实现 Comparable 接口从而根据键对元素进 行排 序。
    * Collections 工具类的 sort 方法有两种重载的形式，
    * 第一种要求传入的待排序容器中存放的对象比较实现 Comparable 接口以实现元素的比较；
    * 第二种不强制性的要求容器中的元素必须可比较，但是要求传入第二个参数，参数是Comparator 接口的子类型（需要重写 compare 方法实现元素的比较），
    * 相当于一个临时定义的排序规则，其实就是通过接口注入比较元素大小的算法，也是对回调模式的应用（Java 中对函数式编程的支持）。
    * */
    public static void main(String[] args) {
        TreeSet<Person> sets = new TreeSet<Person>();

        Person person1 = new Person();
        person1.setId(1);
        Person person3 = new Person();
        person3.setId(3);
        Person person2 = new Person();
        person2.setId(2);
        sets.add(person1);
        sets.add(person3);
        sets.add(person2);
        System.out.println(sets);


    }
}
