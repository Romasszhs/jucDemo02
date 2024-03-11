package com.hang.juc.deadlock;

/**
 * 这是极海的题目考虑主线程和子线程的资源会不会出现竞争，导致死锁出现
 * 情况一：主线程在还没起异步线程时，不会出现资源竞争，原因时主线程是串行执行指令的没有，执行完主线程的方法内容前不会继续执行后续起线程的操作，所以不会死锁
 * 情况二：主线程起了异步线程后，发生了资源竞争，所以会有死锁发生。
 * @author: hangshuo
 * @date: 2022/03/29 22:20
 * @Description:
 */

public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();


        LockRunner lockRunner = new LockRunner();


        // 情况一 主线程串行化执行程序，执行lock时还不会启动子线程

        lockRunner.lock(a,b);

        new Thread(()->{
            try {
                lockRunner.lock(b,a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"thread-101").start();



        // 情况二  主线程先起了子线程，自己再执行锁，所以会导致死锁
        /*
        new Thread(()->{
            try {
                lockRunner.lock(b,a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"thread-101").start();

        lockRunner.lock(a,b);
        */

    }

    static class LockRunner{
        public void lock(Object owner,Object target) throws InterruptedException {
            synchronized (owner){
                Thread.sleep(1000);

                synchronized (target){
                    System.out.println("success");
                }
            }
        }

    }

}
