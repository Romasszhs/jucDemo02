package com.hang.juc.future.异常处理;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: hangshuo
 * @date: 2021/05/27 18:02
 * @Description:
 */

public class CompletableFutureException {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
            return (66 / 0);
        }).thenApply(r -> r * 10);

        //方式一  相当于捕获异常，uncheck异常
        // System.out.println(cf.join());

        // 方式二  捕获异常
        /*try {
            System.out.println(cf.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        //方式三 直接抛出异常
        System.out.println(cf.get());

        System.out.println("1111111111111");

    }

}
