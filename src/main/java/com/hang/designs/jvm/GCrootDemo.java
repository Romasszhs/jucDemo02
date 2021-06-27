package com.hang.designs.jvm;

public class GCrootDemo {
    private byte[] byteArray = new byte[100*1024*1024];

    public static void m1(){
        GCrootDemo g1 = new GCrootDemo();
        System.gc();
        System.out.println("第一次GC完成");
    }

    public static void main(String[] args) {
        m1();
    }
}
