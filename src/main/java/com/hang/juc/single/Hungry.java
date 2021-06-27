package com.hang.juc.single;

//饿汉式
public class Hungry {
    //可能造成空间浪费
    private byte[] data1 = new byte[1024];
    private byte[] data2 = new byte[1024];
    private byte[] data3 = new byte[1024];
    private byte[] data4 = new byte[1024];

    private Hungry(){

    }

    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance(){
        return HUNGRY;
    }
}
