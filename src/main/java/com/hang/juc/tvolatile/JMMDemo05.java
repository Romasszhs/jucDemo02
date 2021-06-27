package com.hang.juc.tvolatile;

public class JMMDemo05 {
    private static volatile  int num = 0 ;

    // 使用synchronized  同步静态方法 锁对象是 类名.class
    private static synchronized void increase(){
        num++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j=0; j <1000;j++){
                    increase();
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        // 如果没有使用synchronized同步静态方法  输出8912
        System.out.println(num); // 10000
    }
}
