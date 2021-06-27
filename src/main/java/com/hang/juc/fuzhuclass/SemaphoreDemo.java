package com.hang.juc.fuzhuclass;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

//停车位例子  进行限流
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 线程数量 代表 停车位
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+" 抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+" 离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            },String.valueOf(i+1)).start();
        }
    }
}
