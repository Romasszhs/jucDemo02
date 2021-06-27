package com.hang.io;

import java.io.*;

public class fileStreamTest2 {
    public static void main(String[] args) throws Exception {
        OutputStreamWriter writer = null;//new OutputStreamWriter()
        FileWriter writer1 = new FileWriter("a.txt");
        writer1.write("中文输入");
        writer1.close();

        // 只使用字符流进行操作，无定义编码解码格式的方法
        FileOutputStream fos = new FileOutputStream(new File("a.txt"));
        OutputStreamWriter writer2 = new OutputStreamWriter(fos,"utf-8");
        writer2.write("中文好");

        writer2.close();
    }
}
