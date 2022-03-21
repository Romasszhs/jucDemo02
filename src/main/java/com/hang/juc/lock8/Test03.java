package com.hang.juc.lock8;

import java.util.concurrent.TimeUnit;

// 5. 增加两个静态的同步方法,两个线程分别执行发送邮件和发送短信，先输出？ 发送邮件
// 6. 增加一个phone1和phone2，使用它们来分别再线程中调用发送邮件和发送短信，先输出？ 发送邮件 原因见Phone3类
//    类一加载就可以调用了！锁的是Class模板，不是方法调用者
public class Test03 {
    public static void main(String[] args) {

        Phone3 phone = new Phone3();
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();

        new Thread(()->{
//            phone.sendEmail();
//            phone1.sendEmail();
            Phone3.sendEmail();
        },"线程A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
//            phone.sendMsg();
//            phone2.sendMsg();
            Phone3.sendMsg();
        },"线程B").start();
    }
}

//每个类都有唯一的Class类对象
class Phone3{
    // synchronized 锁对象是方法的调用者
    // static 静态方法
    // 类一加载就可以调用了！锁的是Class模板，不是方法调用者
    public static synchronized void sendEmail(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发送邮件");
    }
    public static synchronized void sendMsg(){
        System.out.println("发送短信中");
    }

}
