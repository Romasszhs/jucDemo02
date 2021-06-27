package com.hang.juc.readwritelock;


import com.google.errorprone.annotations.Var;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
* ReadWriteLock
*
* */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        //写入
        for (int i = 1; i <= 5; i++) {
            int temp = i;
            new Thread(()->{
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }

        //读取
        for (int i = 1; i <= 5; i++) {
            int temp = i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }

        /*
            1写入1
            1写入成功
            4写入4
            4写入成功
            3写入3
            3写入成功
            2写入2
            2写入成功
            3读取3
            2读取2
            2读取成功
            3读取成功
            5写入5
            5写入成功
            1读取1
            4读取4
            5读取5
            1读取成功
            5读取成功
            4读取成功
        * */
    }
}

class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    //读写锁  更加细粒度的控制
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    //ReentrantLock reentrantLock = new ReentrantLock();
    //存 写入的时候，只希望同时只有一个线程在写  并且不可以读
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    // 取 读的时候可以所有人读  但不可以写
    public void get(String key){
        readWriteLock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

}
