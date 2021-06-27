package com.hang.juc.lock8;

import java.util.concurrent.TimeUnit;

//  1、标准访问，请问先打印邮件还是短信？邮件
//  2、邮件方法暂停4秒钟，请问先打印邮件还是短信？ 邮件
//  锁对象是方法的调用者，但凡锁未被释放都要阻塞，发短信被阻塞。所以先发邮件
public class Test01 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendEmail();
        },"线程A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.sendMsg();
        },"线程B").start();
    }
}

class Phone{
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
}
