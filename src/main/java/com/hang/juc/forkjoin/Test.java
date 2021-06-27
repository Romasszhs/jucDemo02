package com.hang.juc.forkjoin;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
         * 求和计算
         * 3000 6000（ForkJoin）  9000（Stream并行流）
         *
         * */
        //test01();//时间：450
        System.out.println(11/3);
        Random random = new  Random(10  );
        System.out.println(random.nextInt(100));
        System.out.println(random.nextInt(100));
        System.out.println(random.nextInt(100));
        System.out.println(random.nextInt(100));
        System.out.println(random.nextInt(100));
        System.out.println(random.nextInt(100));
        System.out.println(random.nextInt(100));
        System.out.println(random.nextInt(100));
        System.out.println(random.nextInt(100));

        test02();

        //test03();
    }


    public static void test01(){
        long start = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0L; i < 10_0000_0000L; i++) {
            sum +=i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"\t时间："+(end-start));
    }

    // ForkJoin
    public static void test02() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 1001L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);

        long sum = submit.get();

        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"\t时间："+(end-start));
    }

    public static void test03(){
        long start = System.currentTimeMillis();
        //Stream并行流
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);


        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"\t时间："+(end-start));
    }
}
