package com.hang.juc.lockTest2;

/*
* 实现交替执行10次
*
* */
public class Demo01 {
    public static void main(String[] args) {

        Data data = new Data();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                    //Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程A").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                try {
                    data.increment();
                    //Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {

                    data.decrement();
                    //Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                    //Thread.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程D").start();

    }
}

class Data{
    private int num=0;

    // 对于非static方法，同步锁就是this
    public synchronized void increment() throws InterruptedException {
        //不使用循环来进行判断会发生虚假(过早)唤醒
        /*
        * 这个代码启动了四个线程,三个RemoveThread,一个AddThread,并且使用休眠的方式,让添加线程休眠600毫秒,删除线程休眠100毫秒,三个删除线程调用的remove方法,由于使用了synchronized修饰,所有每一次只有一个线程进行if判断,第一个线程肯定判断为true,走到wait方法,
        * 此时wait方法会释放锁,并且在此阻塞,那么第二个和第三个线程也会相继执行到同一程度.600毫秒后,添加线程添加一个记录到list集合,并且通知所有的使用list锁住的线程,加入第一个线程先恢复,抢到了锁,它会正确删除集合,之后释放锁,第二个线程抢到之后由于直接remove集合元素,
        * 此时集合为空,必定报错.这就出现了过早唤醒的问题了.
        * 本例就是num会出现-1的情况，当越多线程是执行减操作时，负数的绝对值会越来越大
        * */
        //解决办法就是讲竞态条件放在while循环里面,唤醒之后继续判断,此时便不会出现异常了.
        if (num>=1){
            this.wait();
        }
//        while (num>=1){
//            wait(); // 等于 this.wait()
//        }
        num++;

        System.out.println(Thread.currentThread().getName()+"\t "+num);

        //this.notify(); // 仅唤醒一个处于等待状态的线程
        this.notifyAll(); // 唤醒同一个对象上所有调用wait方法的线程，处于等待状态的线程

    }

    public synchronized void decrement() throws InterruptedException {
//        if (num==0){
//            this.wait();
//        }
        while (num==0){
            wait();
        }

        num--;
        System.out.println(Thread.currentThread().getName()+"\t "+num);
        this.notify();
    }
}
