package com.hang.collectionDemo.collection;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author: hangshuo
 * @date: 2021/04/25 23:50
 * @Description:
 */

public class fanxinTest {
    public static void main(String[] args) {
        //泛型通配符<? extends T>来接收返回的数据，此写法的泛型集合不能使用 add 方法，
        //而<? super T>不能使用 get 方法，两者在接口调用赋值的场景中容易出错。
        List<? extends String> list=Lists.newArrayList();
        //list.add("123");

        //说明：扩展说一下 PECS(Producer Extends Consumer Super)原则：
        // 第一、频繁往外读取内容的，适合用<? extends T>。
        // 第二、经常往里插入的，适合用<? super T>
    }
}
