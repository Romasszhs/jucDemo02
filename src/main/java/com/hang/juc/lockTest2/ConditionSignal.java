package com.hang.juc.lockTest2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionSignal implements Runnable  {
    private Lock lock;
    private Condition condition;

    public ConditionSignal(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }



    @Override
    public void run() {
        System.out.println("begin - ConditionDemoSignal");
        try {
            lock.lock();
            condition.signal();
            System.out.println("end - ConditionDemoSignal");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
