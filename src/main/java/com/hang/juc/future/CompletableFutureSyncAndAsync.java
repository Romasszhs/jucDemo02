package com.hang.juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author: hangshuo
 * @date: 2021/05/25 17:40
 * @Description:
 */

public class CompletableFutureSyncAndAsync {
    public static void main(String[] args)  {
        /*
        * 首先我们开启一个异步任务，接着串行执行后续两个任务。
        * 任务 2 需要等待任务1 执行完成，任务 3 需要等待任务 2。
        * */

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(()->{
            System.out.println("开始执行cf任务内容");
            sleep(2,TimeUnit.SECONDS);
            System.out.println(10/0);
            return "hello，这是支持异步的供给型接口实现的任务！！！";
        })
                .thenApply((s)-> s+"@ZHANG")
                .thenApply(String::toUpperCase);
        // 上面的任务是异步执行的所以不会影响main线程继续执行下述内容
        System.out.println("1111111111111");

        System.out.println(cf.join());
//        cf.whenCompleteAsync((result,e)->{
//            if (e!=null){
//                System.out.println(e.getMessage());
//            }
//            System.out.println("cf任务内容执行的结果："+result);
//        });
//        System.out.println("2222222222222");

        // 保证main线程不在其他线程池未执行结束前，关闭main线程，设置条件大于2的原因是默认有main和GC线程
        System.out.println(Thread.activeCount());
        while (Thread.activeCount()>2){
            Thread.yield();
        }
    }

    static void sleep(int i, TimeUnit timeUnit){
        try {
            timeUnit.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
