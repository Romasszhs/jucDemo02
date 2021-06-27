package com.hang.threadwaitnotify;

/**
 * @author: hangshuo
 * @date: 2021/04/18 10:58
 * @Description:
 */

public class WaitThread  {

    public static void main(String[] args) {
        NotifyThread notifyThread = new NotifyThread();
        notifyThread.start();
        System.out.println("notifyThread is start");
        synchronized (notifyThread){
            try {
                System.out.println("waiting for notifyThread to complete");
                notifyThread.wait();
                System.out.println("completed.Now back to main thread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Total is : "+ notifyThread.total);
        }

    }



}
