package com.hang.juc.spinlock;

/**
 * @author: hangshuo
 * @date: 2021/04/24 23:11
 * @Description:
 */

public class DeadLockDemo {
    public static void main(String[] args) {
        String A = "A";
        String B = "B";
        new Thread(new HoldLockThread(A,B),"TREAD-A").start();
        new Thread(new HoldLockThread(B,A),"TREAD-B").start();

    }
}
