package com.hang.juc.lockTest2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* 介绍ReentrantLock可重入锁
* 维护一个state=0时表示无锁，进入一个锁就加1，释放锁就减1
* */
public class AtomicDemo  {
    private static int count = 0 ;
    static Lock lock = new ReentrantLock();
    public static void inc(){
        lock.lock();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0 ;i<1000;i++){
            new Thread(()->{
                AtomicDemo.inc();
            }).start();

        }
        Thread.sleep(3000);
        System.out.println("result:"+count);
    }
}
