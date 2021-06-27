package com.hang.juc.future;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: hangshuo
 * @date: 2021/05/24 17:37
 * @Description:
 */

public class ExecutorServiceTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(()->{
                    System.out.println("这个时Runnable的call方法的执行内容");
                },10, TimeUnit.SECONDS );

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);
        scheduledThreadPoolExecutor.schedule(()->{
            System.out.println("这个时Runnable的call方法的执行内容");
        },10, TimeUnit.SECONDS );

    }
}
