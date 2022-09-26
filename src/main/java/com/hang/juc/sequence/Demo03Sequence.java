package com.hang.juc.sequence;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* 题目：多线程之间按顺序调用，实现 A->B->C
* 三个线程启动，要求如下：
* AA 打印5次，BB 打印10次。CC打印15次，依次循环
 * */
public class Demo03Sequence {
    public static void main(String[] args) {
        Resources resources = new Resources();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {

                resources.print5();
            }
        },"线程A").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {

                resources.print10();
            }
        },"线程B").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {

                resources.print15();
            }
        },"线程C").start();


    }
}

class Resources{
    private int num=1;//  num等于1时，线程A执行  num等于2时，线程B执行  num 等于3时，线程C执行
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public  void print5()  {
        lock.lock();
        try {
            while (num!=1){
                condition1.await();
            }


            for (int i = 1; i <= 1; i++) {

                System.out.println(Thread.currentThread().getName()+"=>\t AAAAA");
            }

            num=2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public  void print10()  {
        lock.lock();
        try {
            while (num!=2){
                condition2.await();
            }
            for (int i = 1; i <=2 ; i++) {

                System.out.println(Thread.currentThread().getName()+"=>\t BBBBB");
            }
            num=3;


            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public  void print15()  {
        lock.lock();
        try {
            while (num!=3){
                condition3.await();
            }
            for (int i = 1; i <=3 ; i++) {

                System.out.println(Thread.currentThread().getName()+"->\t CCCCC");
            }

            num=1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
