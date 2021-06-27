package com.hang.juc.future;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFutureTask;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: hangshuo
 * @date: 2021/05/24 17:23
 * @Description:
 */

public class GuavaAsyncTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        System.out.println("--------------------");

        System.out.println("--------------------");

        ListenableFutureTask<String> listenableFutureTask = ListenableFutureTask.create(()->{
            //Thread.sleep(2000);
            return "任务返回的内容";
        });

        Futures.addCallback(listenableFutureTask, new FutureCallback<String>() {
            @Override
            public void onSuccess(@Nullable String s) {
                System.out.println("处理返回结果:"+s);
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("处理异常结果："+throwable);
            }
        },Executors.newSingleThreadScheduledExecutor());
        executorService.submit(listenableFutureTask);
    }
}
