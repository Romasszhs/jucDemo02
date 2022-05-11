package com.hang.juc.deadlock;

/**
 * @author: hangshuo
 * @date: 2022/03/29 22:20
 * @Description:
 */

public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();


        LockRunner lockRunner = new LockRunner();


        lockRunner.lock(a,b);

        new Thread(()->{
            try {
                lockRunner.lock(b,a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
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
