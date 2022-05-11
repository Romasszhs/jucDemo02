package com.hang.juc.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: hangshuo
 * @date: 2022/04/07 22:22
 * @Description:
 */

public class FutureTask1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask<>(new Callable<String>() {

            /**
             * Computes a result, or throws an exception if unable to do so.
             *
             * @return computed result
             * @throws Exception if unable to compute a result
             */
            @Override
            public String call() throws Exception {
                return "CALLABLE接口的实现类输出字符串内容";
            }
        });

        System.out.println(futureTask.get());

        FutureTask futureTask1 = new FutureTask(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },"123");

    }
}
