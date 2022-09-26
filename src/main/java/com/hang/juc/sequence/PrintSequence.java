package com.hang.juc.sequence;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: hangshuo
 * @date: 2022/09/08 23:27
 * @Description:
 * 顺序执行先打印A再打印B再打印C，循环往复，直至第100次输出后停止
 */

public class PrintSequence {

    private static Lock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Condition printAConditon = reentrantLock.newCondition();
        Condition printBConditon = reentrantLock.newCondition();
        Condition printCConditon = reentrantLock.newCondition();

        Thread threadA = new Thread(new printRunner(reentrantLock, 34, printAConditon, printBConditon, "A"), "Thread-A");

        Thread threadB = new Thread(new printRunner(reentrantLock, 33, printBConditon, printCConditon, "B"), "Thread-B");

        Thread threadC = new Thread(new printRunner(reentrantLock, 33, printCConditon, printAConditon, "C"), "Thread-C");

        threadA.start();
        threadB.start();
        threadC.start();

    }

    public static class printRunner implements Runnable{
        private Lock lock;

        private Integer count;

        private Condition  currCondition;

        private Condition nextCondition;

        private String printAlpa;

        private Integer index = 0;

        public printRunner(Lock lock, Integer count, Condition currCondition, Condition nextCondition, String printAlpa) {
            this.lock = lock;
            this.count = count;
            this.currCondition = currCondition;
            this.nextCondition = nextCondition;
            this.printAlpa = printAlpa;
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            while (true){
                lock.lock();
                if (index <count){
                    System.out.println(Thread.currentThread().getName()+" print: "+printAlpa);
                    index++;
                }
                nextCondition.signal();
                try {
                    currCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }

        }
    }
}
