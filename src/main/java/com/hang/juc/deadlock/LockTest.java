package com.hang.juc.deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: hangshuo
 * @date: 2021/10/04 21:59
 * @Description:
 */

public class LockTest implements Runnable{

    private Object resourceA;
    private Object resourceB;

    public LockTest(Object resourceA, Object resourceB) {
        this.resourceA = resourceA;
        this.resourceB = resourceB;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        synchronized (resourceA){
            System.out.println(Thread.currentThread().getName() +"lock:" +resourceA+"=>wait for get"+resourceB);

            // 定时休眠的方式
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Thread.sleep(2000);
            synchronized (resourceB){
                System.out.println(Thread.currentThread().getName() +"lock:" +resourceB+"=>wait for get"+resourceA);
            }

        }
    }
}
