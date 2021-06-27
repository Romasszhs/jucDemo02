package com.hang.juc.lockTest1;

public class SaleTicket  {
    public static void main(String[] args) {
        // 同步方法

        // 同步锁是类名.class
        // 使用类锁来处理资源，Ticket.class是锁，所以即使是多对象，也是同步的操作资源
        // 当然单对象更是同步的操作资源
//        Ticket ticket = new Ticket();
//        Ticket ticket1 = new Ticket();
//
//        new Thread(()->{
//            for (int i = 0; i < 35; i++) {
//                ticket.sale();
//                //等同于 Ticket.sale()
//            }
//        },"A").start();
//        new Thread(()->{
//            for (int i = 0; i < 35; i++) {
//                ticket.sale();//等同于 Ticket.sale()
//            }
//        },"B").start();
//        new Thread(()->{
//            for (int i = 0; i < 35; i++) {
//                ticket1.sale();//等同于 Ticket.sale()
//            }
//        },"C").start();

        // 同步锁是this，锁对象
        // 结果是锁对象是ticket3和ticket4它们不是同步操作同一资源
        Ticket3 ticket3 = new Ticket3();
        Ticket3 ticket4 = new Ticket3();
        new Thread(()->{
            for (int i = 0; i < 35; i++) {
                ticket3.sale();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 35; i++) {
                ticket3.sale();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 35; i++) {
                ticket4.sale();
            }
        },"C").start();
    }
}

class Ticket{
    private static int num = 110;

    public static synchronized void sale(){

        if (num>0) {
            System.out.println(Thread.currentThread().getName()+"卖出了"+(num--)+"张票，剩余"+num);
        }

    }
}

class Ticket3{
    private  int num = 110;

    public synchronized void sale(){

        if (num>0) {
            System.out.println(Thread.currentThread().getName()+"卖出了"+(num--)+"张票，剩余"+num);
        }

    }
}