package com.hang.threadwaitnotify;

/**
 * @author: hangshuo
 * @date: 2021/04/18 11:00
 * @Description:
 */

public class NotifyThread extends Thread {
    int total;

    @Override
    public  void run() {
        synchronized (this){
            System.out.println("notifyThread is running");
            for (int i = 0; i < 100; i++) {
                total += i;
                System.out.println("Total is :"+total);
            }
            this.notify();
        }
    }

}
