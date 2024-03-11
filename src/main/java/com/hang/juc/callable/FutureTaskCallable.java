package com.hang.juc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTaskCallable {
    public static void main(String[] args)  {
        FutureTask<String> ft = new FutureTask<>(new MyThread());
        FutureTask<String> ft2 = new FutureTask<>(new MyThread());

        new Thread(ft, "A").start();  //Thread怎么启动Callable
        new Thread(ft, "B").start();
        //执行同一个对象，则结果可能会缓存

        // 一个FutureTask对象只会被执行至多一次，对象维护一个state属性，分辨是否是任何线程的第一次调用。
        try {
            //结果可能需要等待，会阻塞
            String s = ft.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("HELLO ThreadName: "+Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(4);
        return "HELLO,I AM RETURN.ThreadName: "+ Thread.currentThread().getName();
    }
}