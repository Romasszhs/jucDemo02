package com.hang.juc.spinlock;

import java.util.concurrent.atomic.AtomicReference;

/*
* 自旋锁
*
* */
public class SpinLockDemo {
    // int      基本类型 默认值为0
    // Thread   引用类型  默认值为null
    // 使用 原子引用 来
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    //加锁
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"===>myLock");

        //自旋锁
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }

    //解锁
    public  void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"===>myUnLock");
        atomicReference.compareAndSet(thread,null);
    }


}
