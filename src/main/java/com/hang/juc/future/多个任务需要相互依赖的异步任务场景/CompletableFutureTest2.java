package com.hang.juc.future.多个任务需要相互依赖的异步任务场景;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author: hangshuo
 * @date: 2021/05/27 17:46
 * @Description:
 */

public class CompletableFutureTest2 {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("完成任务");

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            sleep(5, TimeUnit.SECONDS);
            return "hello,任务一的结果";
        });

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            sleep(3, TimeUnit.SECONDS);
            return "hello，任务二的结果";
        });

        // 执行OR关系
        // 由于任务二休眠时间短，任务三获得的结果来自任务二，所以获得任务三的结果和任务二相同
        CompletableFuture<String> cf3 = cf.applyToEither(cf2, (s) -> {
            return s;
        });

        System.out.println(cf2.join());
        System.out.println(cf3.join());
        System.out.println("bool:"+cf2.join().equals(cf3.join()));
    }

    static void sleep(int i, TimeUnit timeUnit){
        try {
            timeUnit.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
