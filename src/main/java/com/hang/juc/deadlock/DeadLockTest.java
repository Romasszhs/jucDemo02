package com.hang.juc.deadlock;

/**
 * @author: hangshuo
 * @date: 2022/09/06 21:56
 * @Description:
 */

public class DeadLockTest {
    public static void main(String[] args) throws InterruptedException {
        Object resourceA = new Object();
        Object resourceB = new Object();


        LockRunner lockRunner = new LockRunner();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lockRunner.run(resourceA,resourceB);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        lockRunner.run(resourceB,resourceA);
    }

    public static class LockRunner{
        public void run(Object objA , Object objB) throws InterruptedException {
            synchronized (objA){
                Thread.sleep(1000);

                synchronized (objB){
                    System.out.println("success");
                }
            }
        }
    }
}
