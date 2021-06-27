package com.hang.practice;

/**
 * @author: hangshuo
 * @date: 2021/05/10 17:26
 * @Description:
 */

public class StringBuilderDemo {
    public static void main(String[] args) throws Exception {
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        sb1.append("a");
                    }
                }
            }).start();
        }

        Thread.sleep(100);
        System.out.println(sb1.length());
    }
}
