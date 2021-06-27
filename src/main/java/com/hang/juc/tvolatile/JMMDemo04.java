package com.hang.juc.tvolatile;

import java.util.concurrent.atomic.AtomicInteger;

// volatile不保证原子性
// 如何保证原子性 ？？
// 使用原子类

/*
    这里的 volatile 关键字主要是为了防止指令重排。

    如果不用 ，singleton = new Singleton();，这段代码其实是分为三步：

    分配内存空间。(1)
    初始化对象。(2)
    将 singleton 对象指向分配的内存地址。(3)
    加上 volatile 是为了让以上的三步操作顺序执行，
    反之有可能第三步在第二步之前被执行
    就有可能某个线程拿到的单例对象是还没有初始化的，以致于报错。
* */
public class JMMDemo04 {
    private volatile static AtomicInteger num = new AtomicInteger();

    public static void add(){
        //num++;  // 不是一个原子性操作
        num.getAndIncrement(); //AtomicInteger + 1 方法  CAS
        /*
        * 1.获取这个值
        * 2. add 1
        * 3.写回这个值
        * */
    }

    public static void main(String[] args) {
        for (int i =1;i<=20;i++) {
            new Thread(()->{    //线程 1 对主内存的变化不知道的
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount()>2){ // main gc
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+" "+num);// main 20000
    }
}
