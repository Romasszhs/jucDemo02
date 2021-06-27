package com.hang.juc.fuzhuclass;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// 简单理解为一个加法计数器 CyclicBarrier
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(5, () -> {
            System.out.println("到达计数器的目标点");
        });
        int j = 0 ;
        for (int i = 0; i < 5; i++) {
            int temp = i;
            /*
            * Lambda作用域：
            * 在Lambda表达式中访问外层作用域和老版本的匿名对象中的方式很相似。
            * 可以直接访问标记了final的外层局部变量，或者实例的字段以及静态变量。
            * 但是如果访问局部变量，要求局部变量必须是final修饰的。
            *
            * */
            new Thread(()->{

                System.out.println(Thread.currentThread().getName()+"收集"+temp+"个数");
                System.out.println(cb.toString());// 打印cd相当于调用toString方法
                System.out.println(j);
                //j=1; 尝试赋值报错
                //Variable used in lambda expression should be final or effectively final
                //相当于   在lambda内部域必须为final jdk8底层后都把局部变量改为final
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }


    }
}
