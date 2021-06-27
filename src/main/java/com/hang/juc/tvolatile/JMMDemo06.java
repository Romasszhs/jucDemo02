package com.hang.juc.tvolatile;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JMMDemo06 {
    // 不添加volatile的情况下可能出现a=1，b=1
    // 以上数字的执行顺序可能会导致  a=1，b=1的出现
    // 这是处理器乱序执行的结果：线程t1内部的两行代码之间不存在数据依赖
    // 因此，可以将x = 1乱序到 a=y 前；同时，线程t2中的y = 1早于线程t1中的执行。一个可能的执行序列如下：
    // y=1 x=1 a=y=1 b=x=1
    // 也就是说，单纯解决内存可见性问题是不够的，还需要专门解决处理器重排序的问题。
    static /*volatile*/ int x=0 , y=0;

    public static void main(String[] args) throws InterruptedException {
        Set<String> resultSet = new HashSet<>();
        Map<String, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < 1000000; i++) {
            x=0;y=0;
            resultMap.clear();
            Thread one = new Thread(()->{
                int a =y; //3
                x=1; //2
                resultMap.put("a",a);
            });

            Thread two = new Thread(()->{
                int b = x; //4
                y=1; //1   以上数字的执行顺序可能会导致  a=1，b=1的出现
                resultMap.put("b",b);
            });

            one.start();
            two.start();
            one.join();
            two.join();

            resultSet.add("a="+resultMap.get("a")+","+"b="+resultMap.get("b"));
            System.out.println(resultSet);
        }
    }
}
