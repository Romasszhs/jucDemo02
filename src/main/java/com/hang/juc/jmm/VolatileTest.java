package com.hang.juc.jmm;

public class VolatileTest {
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("waiting data...");
                while (!flag){

                }
                System.out.println("=================success");
            }
        }).start();

        Thread.sleep(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                prepareData();
            }
        }).start();
    }

    private static void prepareData() {
        System.out.println("Preparing Data ....");
        flag = true;
        System.out.println("prepare Date end ...");
    }
}
