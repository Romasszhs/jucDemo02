package com.hang.juc.fuzhuclass;

import java.util.concurrent.CountDownLatch;

// 简单理解为一个减法计数器  CountDownLatch
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(6);// 总数是6
        // 必须要执行任务的时候，再使用，例如关门操作
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println("线程编号："+Thread.currentThread().getName()+"\t is GO OUT");
                cdl.countDown();

            },String.valueOf(i)).start();
        }
        cdl.await();//等待计数器归零，然后继续向下执行程序

        System.out.println("THE END 关门");


    }
}
