package com.hang.juc.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

// BlockingQueue的四种API  对数据分别进行添加 、删除、查询
// 1.报告异常    2.不报异常有返回值  3. 等待阻塞     4.等待阻塞超时退出
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        //Exception in thread "main" java.lang.IllegalStateException: Queue full
        test04();
    }

    /*
    * 抛出异常
    * */
    public static void test01(){
        // 队列大小
        ArrayBlockingQueue blockingQueue =  new ArrayBlockingQueue<>(3 );

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.element());//检查队首


        //System.out.println(blockingQueue.add("d"));
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.element());//检查队首
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //Exception in thread "main" java.util.NoSuchElementException
        //System.out.println(blockingQueue.remove());



    }

    public static void test02(){
        // 队列大小
        ArrayBlockingQueue blockingQueue =  new ArrayBlockingQueue<>(3 );

        System.out.println(blockingQueue.offer("A"));
        System.out.println(blockingQueue.offer("B"));
        System.out.println(blockingQueue.offer("C"));
        System.out.println(blockingQueue.offer("D"));//false  不抛异常
        System.out.println(blockingQueue.peek());//检查队首，并返回值

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.peek());//检查队首，并返回值
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());// null
    }

    /*
    * 等待一直阻塞
    *
    * */
    public static void test03() throws InterruptedException {
        // 队列大小
        ArrayBlockingQueue blockingQueue =  new ArrayBlockingQueue<>(3 );
        // 一直阻塞
        blockingQueue.put("A");
        blockingQueue.put("B");
        blockingQueue.put("C");
        System.out.println(blockingQueue.take());
        blockingQueue.put("D");


        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        //System.out.println(blockingQueue.take());

    }

    /*
    * 等待超时退出
    *
    * */
    public static void test04() throws InterruptedException {
        // 队列大小
        ArrayBlockingQueue blockingQueue =  new ArrayBlockingQueue<>(3 );
        // 等待阻塞超时退出
        blockingQueue.offer("A",2,TimeUnit.SECONDS);
        blockingQueue.offer("B",2,TimeUnit.SECONDS);
        blockingQueue.offer("C",2,TimeUnit.SECONDS);


        System.out.println(blockingQueue.poll());
        blockingQueue.offer("D",2,TimeUnit.SECONDS);
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(1, TimeUnit.SECONDS));

    }

}
