package com.hang.juc.reentrantLock;

/**
 * @author: hangshuo
 * @date: 2021/04/24 22:39
 * @Description:
 */

// 也就是说线程可以进入任何一个它已经拥有的锁，所同步着的代码块。
// 可重入锁 指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁。
public class ReentrantLockDemo1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendMSG("你好");
        },"线程A").start();

        new Thread(()->{
            phone.sendMSG("你好 小蔡");
        },"线程B").start();
    }
}

class Phone{
    public synchronized void sendMSG(String str){
        System.out.println("发送短信的内容为："+str);
        sendEmail(str);
    }


    public synchronized  void sendEmail(String str) {
        System.out.println("邮件的内容："+str);
    }
}
