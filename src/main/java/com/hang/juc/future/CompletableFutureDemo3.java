package com.hang.juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

/**
 * @author: hangshuo
 * @date: 2021/04/24 1:32
 * @Description:
 */

public class CompletableFutureDemo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 执行异步任务
        CompletableFuture cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("cf 任务执行开始");
            // 下面的休眠代码块注释与否决定是否会被外部操作设置该lambda代码块的返回结果值
            // 当该lambda代码块执行结束并有返回结果，外部不可设置返回结果，即cf.complete("外部设置任务返回结果内容");
            sleep(5, SECONDS);

            System.out.println("cf 任务执行结束");
            return "楼下小黑哥";
        });

        Executors.newSingleThreadScheduledExecutor().execute(() -> {
            sleep(3, SECONDS);

            System.out.println("主动设置 cf 任务结果");
            // 设置任务结果，由于 cf 任务未执行结束，结果返回 true
            boolean bool = cf.complete("程序通事");
            System.out.println("主动设置 cf 任务结果:"+bool);
        });
        // 由于 cf 未执行结束，将会被阻塞。5 秒后，另外一个线程主动设置任务结果
        System.out.println("get:" + cf.get());
        // 等待 cf 任务执行结束
        sleep(5, SECONDS);
        // 由于已经设置任务结果，cf 执行结束任务结果将会被抛弃
        System.out.println("get:" + cf.get());

        System.out.println("当前线程为："+Thread.currentThread());
        System.out.println("目前存活的线程数："+Thread.activeCount());
/***
 * cf 任务执行开始
 * 主动设置 cf 任务结果
 * get:程序通事
 * cf 任务执行结束
 * get:程序通事
 */
    }

    static void sleep(int time,TimeUnit timeUnit){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
