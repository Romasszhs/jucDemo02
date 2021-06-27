package com.hang.juc.spinlock;

/**
 * @author: hangshuo
 * @date: 2021/04/24 23:12
 * @Description:
 */

public class HoldLockThread  implements Runnable {

    private String resouce1;
    private String resouce2;

    public HoldLockThread(String resouce1, String resouce2) {
        this.resouce1 = resouce1;
        this.resouce2 = resouce2;
    }

    @Override
    public void run() {
        synchronized (resouce1){
            System.out.println(resouce1 + resouce2);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (resouce2){
                System.out.println(resouce1 + resouce2);
            }

        }

    }
}
