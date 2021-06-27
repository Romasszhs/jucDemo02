package com.hang.juc.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Demo01 {
    public static void main(String[] args) {
        // 只有一个线程
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        // 执行很多短期异步任务，线程池根据需要创建新线程，但在先构建的线程可用时将重用，可扩容，遇强则强
        ExecutorService threadPool2 = Executors.newCachedThreadPool();

        // 执行长期任务性能好，创建一个线程池，有固定的线程数的线程
        ExecutorService threadPool3 = Executors.newFixedThreadPool(10);

        try {
            for (int i = 0; i < 30; i++) {
                // 添加了延时后，只有一个线程在处理我们的线程业务。没添加延时，大概有12个线程在线程池内。
                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadPool2.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\tHELLO");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool2.shutdown();
        }
    }
}
