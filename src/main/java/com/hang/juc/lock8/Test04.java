package com.hang.juc.lock8;

/*
* 7.一个静态同步方法和一个普通同步方法，phone对象分别再线程中执行先输出？发送邮件
*   默认情况锁Class模板的不用等待main线程的sleep 锁phone对象要等待main线程的sleep
*   先输出发送邮件（静态同步方法）
* 8. 一个静态同步方法和一个普通同步方法，连个对象分别执行静态方法和普通方法，先输出？发送邮件
*   在main线程不sleep的情况下，也是先输出发送邮件（静态同步方法）
* 相当于两个锁，锁两个门，不相干
* 但是锁普通方法的调用者会被main方法的sleep影响
* 锁Class模板不会被影响
* */
public class Test04 {
    public static void main(String[] args) {
        //Phone4 phone = new Phone4();
        Phone4 phone1 = new Phone4();
        Phone4 phone2 = new Phone4();

        new Thread(()->{
            //phone.sendEmail();
            phone1.sendEmail();
        },"线程A").start();

        /*try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        new Thread(()->{
            //phone.sendMsg();
            phone2.sendMsg();
        },"线程B").start();
    }
}

//每个类都有唯一的Class类对象
class Phone4{
    // 静态同步方法
    // 类一加载就可以调用了！锁的是Class模板，不是方法调用者
    public static synchronized void sendEmail(){

        System.out.println("发送邮件AAA");
    }
    // 普通同步方法  锁调用者
    public  synchronized void sendMsg(){

        System.out.println("发送短信中");
    }

}
