package com.hang.juc.lockTest1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo02  {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();
        new Thread(()->{
            ticket.sale();

        },"C1").start();

        new Thread(()->{

            ticket.sale();

        },"A").start();

        new Thread(()->{

            ticket.sale();

        },"B").start();

    }
}

class Ticket2{
    private  int num = 100;

    Lock lock = new ReentrantLock();

    public  void sale(){
        //lock.lock();
        //为了让非公平锁的特性得到体现，使用线程哄抢资源的方式来获取锁
        while (lock.tryLock()) {

            try {
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出了" + (num--) + "张票，剩余" + num);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
