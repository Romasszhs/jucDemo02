package com.hang.juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: hangshuo
 * @date: 2021/05/25 16:01
 * @Description:
 */

public class CompletableFutureDemo4 {
    public static void main(String[] args)  {
        CompletableFuture cf = CompletableFuture.supplyAsync(()->{
            System.out.println("cf 任务执行开始");
            System.out.println(10/0);
            sleep(8, TimeUnit.SECONDS);
            System.out.println("cf 任务执行结束");

            return "线程任务内容";
        });
        Executors.newSingleThreadExecutor().execute(()->{
            sleep(5,TimeUnit.SECONDS);
            System.out.println("开始主动设置cf的异常结果");
            // 设置任务结果，由于cf任务未执行结束，结果返回true
            boolean bool = cf.completeExceptionally(new RuntimeException("出现问题啦"));
            System.out.println("主动设置cf的异常结果"+bool);

        });


        // 由于cf未执行结束，前5秒将会被阻塞，设置结果为异常后，后续main线程调用cf.get方法，程序抛出异常，结束
        try {
            System.out.println("get:"+cf.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(1111);
    }



    static void sleep(int time, TimeUnit timeUnit){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
