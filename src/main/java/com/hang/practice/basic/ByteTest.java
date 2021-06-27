package com.hang.practice.basic;

/**
 * @author: hangshuo
 * @date: 2021/05/15 17:51
 * @Description:
 */

public class ByteTest {
    public static void main(String[] args) {
        byte[] bytes = new  byte[10];
        // 一个字节八个比特
        bytes[0] = 1;
        bytes[1] = (byte) 128;
        bytes[2] = 127;
        System.out.println(bytes[0]);//1
        System.out.println(bytes[1]);//-128
        System.out.println(bytes[2]);//127
    }
}
