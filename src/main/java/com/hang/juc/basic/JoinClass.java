package com.hang.juc.basic;

/**
 * @author: hangshuo
 * @date: 2021/10/04 21:24
 * @Description:
 */

public class JoinClass implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        JoinClass jc = new JoinClass();
        Thread thread = new Thread(jc);
        thread.start();

        for (int i = 0; i < 100; i++) {
            if(i<50){
                thread.yield();
            }
            if (i==50){
                // 使main主线程进行礼让,让当前正在执行的线程暂停，但不阻塞
                // 将线程从运行状态转为就绪状态
                 Thread.yield();

                // Join合并线程，待此线程执行完成后，
                // 再执行其他线程，其他线程阻塞
                //thread.join();
            }
            System.out.println("main: "+ i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("join: "+i);

        }
    }
}
