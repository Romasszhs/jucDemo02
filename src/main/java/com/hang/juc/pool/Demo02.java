package com.hang.juc.pool;

import java.util.concurrent.*;


//自定义线程池的七大参数
// 拒绝策略
// ThreadPoolExecutor.AbortPolicy();//默认，队列满了丢任务，抛出异常
// ThreadPoolExecutor.CallerRunsPolicy();//哪来回哪里
// ThreadPoolExecutor.DiscardPolicy();//队列满了丢任务，不抛出异常【如 果允许任务丢失这是好的】
// ThreadPoolExecutor.DiscardOldestPolicy();//将早进入队列的任务 删，之后再尝试加入队列

public class Demo02 {
    public static void main(String[] args) {
        //自定义线程池的七大参数
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),// 使用默认的线程工厂即可
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        try {
            //最大承载的线程数量为  queue的容量 + maximumPoolSize
            for (int i = 0; i < 9; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\tHELLO");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
