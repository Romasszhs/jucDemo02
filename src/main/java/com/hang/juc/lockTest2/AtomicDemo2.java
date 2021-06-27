package com.hang.juc.lockTest2;

public class AtomicDemo2 {
    private static int count = 0    ;
    public synchronized static void inc() throws InterruptedException {
        Thread.sleep(1);
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0 ;i<1000;i++){
            new Thread(()->{
                try {
                    AtomicDemo2.inc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }
        Thread.sleep(2000);
        System.out.println("result:"+count);
    }
}
