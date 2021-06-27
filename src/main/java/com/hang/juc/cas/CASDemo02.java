package com.hang.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo02 {
    public static void main(String[] args) {
        //CAS  比较并交换
        AtomicInteger atomicInteger = new AtomicInteger(20);


        //  public final boolean compareAndSet(int expect, int update)
        // 期待值   更新值
        //
        System.out.println(atomicInteger.compareAndSet(20, 21));
        System.out.println(atomicInteger.compareAndSet(20, 21));

        System.out.println(atomicInteger.get());
    }
}
