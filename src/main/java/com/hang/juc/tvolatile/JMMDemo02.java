package com.hang.juc.tvolatile;

import java.util.concurrent.TimeUnit;

public class JMMDemo02 {
    // 不加volatile 程序就会死循环
    // 添加volatile实现数据一致性
    private volatile static int num = 0;
    public static void main(String[] args) {
        new Thread(()->{    //线程 1 对主内存的变化不知道的
            while (num==0){

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num = 1;
        System.out.println(num);
    }
}
