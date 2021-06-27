package com.hang.fileReader.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author: hangshuo
 * @date: 2021/04/20 18:14
 * @Description:
 */

public class BufferedDemo03 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("c:\\apache-maven-3.6.3-bin.rar"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("apache-maven-3.6.3-bin.rar"))
        ){
            int len;
            byte[] bytes = new byte[8*2048];
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes,0,len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("使用缓存字节流复制内容并且使用字节数组存储缓存内容的情况下总耗时为："+(end-start)+"ms");
        // 输出： 使用缓存字节流复制内容并且使用字节数组存储缓存内容的情况下总耗时为：790ms
    }
}
