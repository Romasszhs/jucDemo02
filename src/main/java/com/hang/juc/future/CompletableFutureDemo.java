package com.hang.juc.future;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
// Future的优点：比更底层的Thread更易用。
// 要使用Future，通常只需要将耗时的操作封装在一个Callable对象中，再将它提交给ExecutorService。
// 异步调用 CompletableFuture 解决了Future提供的主线程主动问询新线程的问题。
// CompletableFuture在结束新线程后主动告知主线程。

/*
* 异步执行
* 成功回调
* 失败回调
* 有返回值的异步回调  supplyAsync
* 没有返回值的异步回调 runAsync
* */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 没有返回值的异步回调  runAsync
        // 发起一个请求

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"\trunAsync=>Void");

        });
        //TimeUnit.SECONDS.sleep(1);
        TimeUnit.SECONDS.sleep(2);

        System.out.println("1111111111");

        completableFuture.get();

        System.out.println("22222222222");
        // 主线程在发起请求后，继续向下执行代码，直到get 主线程进入阻塞 以获取执行的结果
        // 通过调整主线程的sleep时间为1或3可以知道这个请求是异步的。
        // 情况一：发起的请求中不sleep  主线程也不sleep   先输出111111再输出ForkJoinPool.commonPool-worker-1	runAsync=>Void
        // 情况二：发起的请求中sleep2秒  主线程sleep1秒     先输出111111再输出ForkJoinPool.commonPool-worker-1	runAsync=>Void
        // 情况三：发起的请求中sleep2秒   主线程sleep3秒    先输出ForkJoinPool.commonPool-worker-1	runAsync=>Void再输出1111111
        // 以上情况可以知道请求是异步的

        // 有返回值的异步回调  supplyAsync
        // 成功和失败的回调
//        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
//            System.out.println(Thread.currentThread().getName()+"supplyAsync=>Integer");
//            int i = 10 / 0;
//            return 1024;
//        });
//
//        System.out.println(completableFuture2.whenComplete((t, u) -> {
//            System.out.println("t=>" + t);
//            System.out.println("u=>" + u);
//        }).exceptionally((e) -> {
//            System.out.println(e.getMessage());
//            return 2333;
//        }).get());
    }
}
