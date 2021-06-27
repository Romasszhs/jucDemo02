package com.hang.juc.lock8;

import java.util.concurrent.TimeUnit;

// 3.线程都使用phone1时，增加一个普通方法后，先输出发送邮件还是Hello？  Hello
// 4.增加一个phone2后，线程分别执行有锁的发邮件和发短信的方法，谁先输出？  发送短信中
public class Test02 {
    public static void main(String[] args) {
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();
        new Thread(()->{
            phone1.sendEmail();
        },"线程A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone2.sendMsg();
        },"线程B").start();
    }
}

class Phone2{
    public synchronized void sendEmail(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发送邮件");
    }
    public synchronized void sendMsg(){
        System.out.println("发送短信中");
    }

    //没有锁，不受锁的影响
    public void hello(){
        System.out.println("Hello");
    }
}
