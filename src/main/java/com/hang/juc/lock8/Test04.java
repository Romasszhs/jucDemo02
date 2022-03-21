package com.hang.juc.lock8;

import java.util.concurrent.TimeUnit;

/*
* 7.一个静态同步方法和一个普通同步方法，一个phone对象分别main线程中执行先输出？发送短信
*   静态同步方法 被 休息4秒
* 相当于两个锁，锁两个门，不相干
*   先输出 普通同步方法  后调用方法不需等待先调用的方法
* 8. 一个静态同步方法和一个普通同步方法，两个不同对象分别执行静态方法和普通方法，先输出？发送短信
*
* 相当于两个锁，锁两个门，不相干
* 先输出 普通同步方法  后调用方法不需等待先调用的方法
* */
public class Test04 {
    public static void main(String[] args) {
        Phone4 phone = new Phone4();
        Phone4 phone1 = new Phone4();
        Phone4 phone2 = new Phone4();

        new Thread(()->{
            phone.sendEmail();
            //phone1.sendEmail();
        },"线程A").start();


        new Thread(()->{
            phone.sendMsg();
            //phone2.sendMsg();
        },"线程B").start();
    }
}

//每个类都有唯一的Class类对象
class Phone4{
    // 静态同步方法
    // 类一加载就可以调用了！锁的是Class模板，不是方法调用者
    public static synchronized void sendEmail(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发送邮件AAA");
    }
    // 普通同步方法  锁调用者
    public  synchronized void sendMsg(){

        System.out.println("发送短信中");
    }

}
