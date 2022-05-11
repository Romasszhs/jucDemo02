package com.hang.juc.pool.wrongways;

/**
 * @author: hangshuo
 * @date: 2022/04/07 22:44
 * @Description:
 */

public class Lambda {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
