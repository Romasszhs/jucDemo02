package com.hang.designs.jvm;

public class Demo {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        },"线程1").start();
    }

    // native : 凡是带了native关键字的，说明java的作用范围达不到，调用底层c语言的库
    //  会进入本地方法栈
    // 调用本地方法接口   JNI
    private native void start0();
}
