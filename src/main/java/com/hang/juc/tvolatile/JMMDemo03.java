package com.hang.juc.tvolatile;

import java.util.concurrent.TimeUnit;

// volatile不保证原子性
// 如何保证原子性 ？？
public class JMMDemo03 {
    private volatile static int num = 0;

    public static void add(){
        num++;  // 不是一个原子性操作
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
        // 期待的num值是20000,输出的却不是
        System.out.println(Thread.currentThread().getName()+" "+num);// main 19421

    }
}
