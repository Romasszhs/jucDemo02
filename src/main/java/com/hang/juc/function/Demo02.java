package com.hang.juc.function;

import java.util.function.Predicate;

// Predicate 断定型接口  输入一个T，返回一个Boolean
public class Demo02 {
    public static void main(String[] args) {

        // 判断字符串是否为空
        Predicate<String> predicate = (str)->{
            return str.isEmpty();
        };

        System.out.println(predicate.test("zhangsan "));
    }
}
