package com.hang.practice;

/**
 * @author: hangshuo
 * @date: 2021/05/10 17:31
 * @Description:
 */

public class StringBufferDemo {
    public static void main(String[] args) throws InterruptedException {
        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        sb2.append("a");
                    }
                }
            }).start();
        }

        Thread.sleep(100);
        System.out.println(sb2.length());// 10000


    }
}
