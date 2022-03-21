package com.hang.juc.deadlock;

/**
 * @author: hangshuo
 * @date: 2021/10/04 22:02
 * @Description:
 */

public class TestLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Object resourceA = new Object();

        Object resourceB = new Object();

        new Thread(new LockTest(resourceA,resourceB),"thread-1").start();
        new Thread(new LockTest(resourceB,resourceA),"thread-2").start();
    }
}
