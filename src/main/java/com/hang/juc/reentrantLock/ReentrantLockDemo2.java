package com.hang.juc.reentrantLock;

import org.checkerframework.checker.units.qual.C;

import java.util.Collection;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: hangshuo
 * @date: 2021/04/24 22:56
 * @Description:
 */

public class ReentrantLockDemo2 {
    public static void main(String[] args) {
        Computer computer = new Computer();
        new Thread(computer,"线程A").start();
        new Thread(computer,"线程B").start();


    }

}

class Computer implements Runnable{
    Lock lock = new ReentrantLock();


    @Override
    public void run() {
        get();
    }

    private void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" get() 方法");
            set();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    private void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" set() 方法");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}