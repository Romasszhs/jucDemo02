package com.hang.juc.pool.wrongways;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: hangshuo
 * @date: 2022/04/07 22:30
 * @Description:
 */

public class DemoTimmerTask {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },1000,1000);
    }
}
