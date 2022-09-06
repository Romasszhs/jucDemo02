package com.hang.juc.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: hangshuo
 * @date: 2022/07/23 14:01
 * @Description:
 */

public class DebugCallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<String> future2 = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是Runnable接口中实现类中的run方法");
            }
        },"run方法执行完成");

        System.out.println(future2.get());
    }
}
