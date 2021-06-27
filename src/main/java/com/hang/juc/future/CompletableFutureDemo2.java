package com.hang.juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: hangshuo
 * @date: 2021/04/23 19:19
 * @Description:
 */

public class CompletableFutureDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
            //return 1024/0; 该方法执行后会抛出运行时异常java.lang.ArithmeticException: / by zero
            return 1024;
        });

        try {
            System.out.println(completableFuture.get());
            System.out.println(completableFuture.get());
            System.out.println("-----------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(completableFuture
                .whenComplete((answer, throwable) -> {
                    if (throwable!=null){
                        System.out.println("抛出的异常:" + throwable);
                    }
                    System.out.println("执行结果:" + answer);
                })
                .exceptionally(e -> {
                    System.out.println("抛出的异常:" + e.getMessage());
                    return 123;
                }).get());

    }
}
