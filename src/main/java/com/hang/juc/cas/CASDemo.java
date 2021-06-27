package com.hang.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {
        //CAS compareAndSet 比较并交换
        AtomicInteger atomicInteger = new AtomicInteger(20);

        // 出现ABA问题，但是我们不清楚过程。

        //  public final boolean compareAndSet(int expect, int update)
        // 期待值   更新值
        // ===========捣乱的线程===================
        System.out.println(atomicInteger.compareAndSet(20, 21));
        System.out.println(atomicInteger.compareAndSet(21, 20));

        // ===========期望进行操作的线程=================
        System.out.println(atomicInteger.compareAndSet(20, 2222));

        System.out.println(atomicInteger.get());
    }
}
