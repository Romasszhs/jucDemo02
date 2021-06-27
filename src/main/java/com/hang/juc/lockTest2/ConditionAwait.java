package com.hang.juc.lockTest2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionAwait implements Runnable {
    private Lock lock;
    private Condition condition;

    public ConditionAwait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }


    @Override
    public void run() {
        System.out.println("begin ConditionAwait");
        try {
            lock.lock();
            condition.await();
            System.out.println("end ConditionAwait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
