package com.hang.juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CASDemoABA {
    //CAS  比较并交换
    public static void main(String[] args) {
        // AtomicStampedReference 注意： 如果泛型是包装类，注意引用变量的地址会不同的问题。参考阿里开发手册
        // 在企业业务中，我们这里比较的一般都是一个个对象
        AtomicStampedReference<Integer> atomicInteger = new AtomicStampedReference<>(20,1);

        new Thread(()->{
            int stamp = atomicInteger.getStamp();
            System.out.println("A1=>"+stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //第一次对数据进行修改
            System.out.println(atomicInteger.compareAndSet(20,
                    22,
                    atomicInteger.getStamp(),
                    atomicInteger.getStamp() + 1));

            System.out.println("A2=>"+atomicInteger.getStamp());

            //第二次对数据进行修改
            System.out.println(atomicInteger.compareAndSet(22,
                    20,
                    atomicInteger.getStamp(),
                    atomicInteger.getStamp() + 1));
            System.out.println("A3=>"+atomicInteger.getStamp());

        },"A").start();

        new Thread(()->{
            int stamp = atomicInteger.getStamp();
            System.out.println("B1=>"+stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicInteger.compareAndSet(20, 66, stamp, stamp + 1));
            System.out.println("B2=>"+atomicInteger.getStamp());


        },"B").start();

    }
}
