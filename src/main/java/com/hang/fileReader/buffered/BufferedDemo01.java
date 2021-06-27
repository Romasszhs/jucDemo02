package com.hang.fileReader.buffered;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: hangshuo
 * @date: 2021/04/20 18:02
 * @Description:
 */

/*
* 效率测试
* 查询API，缓冲流读写方法与基本的流是一致的，我们通过复制大文件（500MB），测试它的效率。
* */
public class BufferedDemo01 {
    public static void main(String[] args) {
        // 记录开始时间
        long start = System.currentTimeMillis();
        // 创建流对象
        try (
                FileInputStream fis = new FileInputStream("c:\\apache-maven-3.6.3-bin.rar");
                FileOutputStream fos = new FileOutputStream("apache-maven-3.6.3-bin.rar")
        ){
        // 读写数据
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("普通流复制时间:"+(end - start)+" 毫秒");

    }
}
