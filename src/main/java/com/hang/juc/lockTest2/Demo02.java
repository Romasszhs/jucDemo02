package com.hang.juc.lockTest2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class    Demo02 {
    public static void main(String[] args) {
        Data2 data = new Data2();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        },"线程A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        },"线程B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        },"线程C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                    data.decrement();
            }
        },"线程D").start();

    }
}

class Data2{
    private int num=0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public  void increment()  {
        lock.lock();
        try {
            while (num>=1){
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"\t "+num);

            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public  void decrement()  {
        lock.lock();
        try {
            while (num<=0){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"\t "+num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
