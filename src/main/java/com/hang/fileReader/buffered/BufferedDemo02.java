package com.hang.fileReader.buffered;

import java.io.*;

/**
 * @author: hangshuo
 * @date: 2021/04/20 18:07
 * @Description:
 */

public class BufferedDemo02 {
    public static void main(String[] args) {
        // 记录开始时间
        long start = System.currentTimeMillis();
        // 创建流对象
        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("c:\\apache-maven-3.6.3-bin.rar"));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("apache-maven-3.6.3-bin.rar"));
        ){
            // 读写数据
            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("缓冲流复制时间:"+(end - start)+" 毫秒");

        // 输出：缓冲流复制时间:24853 毫秒
    }
}
