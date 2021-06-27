package com.hang.juc.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: hangshuo
 * @date: 2021/04/22 17:26
 * @Description:
 */

// executorService.submit 和 executorService.execute 方法的区别就是
    // execute只允许传入Runnable接口的实现类。
public class TestCallable2 {
    public static void main(String[] args) {
        TestCallable1 callable = new TestCallable1("张三");
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("开始执行call()方法");

        /*
        * 同样submit方法，参数Runnable和Callable也稍微有些不同：
        * 当将Callable的对象传递给ExecutorService的submit方法，则该call方法自动在一个线程上执行，并且会返回执行结果Future对象。
        * 当将Runnable的对象传递给ExecutorService的submit方法，则该run方法自动在一个线程上执行，并且会返回执行结果Future对象，但是在该Future对象上调用get方法，将返回null。
        * */

        Future<String> future = executorService.submit(callable);

        Future<String> future2 = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是Runnable接口中实现类中的run方法");
            }
        },"run方法执行完成");

        Future future3 = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是Runnable接口中实现类中的run方法");
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是executorService.execute方法执行的Runnable接口实现类");
            }
        });

        try {
            //System.out.println("这里是为了测试程序的执行");
            System.out.println("调用call()方法返回的结果："+future.get());//调用call()方法返回的结果：张三

            //System.out.println("这里是为了测试程序的执行");
            System.out.println("调用run()方法返回的结果："+future2.get());//调用run()方法返回的结果：run方法执行完成

            System.out.println("future3的get():"+future3.get());//future3的get():null


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
