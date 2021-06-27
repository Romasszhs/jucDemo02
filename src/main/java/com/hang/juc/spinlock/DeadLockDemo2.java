package com.hang.juc.spinlock;

/**
 * @author: hangshuo
 * @date: 2021/05/11 14:28
 * @Description:
 */

public class DeadLockDemo2 {
    public static void main(String[] args) {
        Integer sto1 = 10;
        Integer sto2 = 20;
        new Thread(new HoldLockThread2(sto1,sto2),"threadA").start();
        new Thread(new HoldLockThread2(sto2,sto1),"threadB").start();

    }
}
