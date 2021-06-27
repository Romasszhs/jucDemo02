package com.hang.juc.lockTest2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(new ConditionAwait(lock,condition),"t1").start();
        new Thread(new ConditionSignal(lock,condition),"t2").start();
    }
}
