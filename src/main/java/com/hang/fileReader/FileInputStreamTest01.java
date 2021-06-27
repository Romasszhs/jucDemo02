package com.hang.fileReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author: hangshuo
 * @date: 2021/04/20 16:24
 * @Description:
 */

public class FileInputStreamTest01 {
    public static void main(String[] args) throws  Exception{
        // 文件内容 你好/r/n中国人
        FileInputStream fis1 = new FileInputStream("hello.txt");
        // 示例一
        int read = fis1.read();
        System.out.println(read);
        System.out.println((char) read);
        while ((read = fis1.read())!=-1){
            System.out.println((char)read);
        }

        // 示例二
        //使用字节数组读取：int read(byte[] b) ，每次读取b的长度个字节到数组中，返回读取到的有效字节个数，
        //读取到末尾时，返回 -1
        FileInputStream fis = new FileInputStream("read.txt");
        byte[] b = new byte[1024];
        int len;
        while ((len = fis.read(b)) != -1) {
            System.out.println(new String(b,0,len));
        }

        fis.close();
        fis1.close();

        // 示例三
        // 复制图片
        FileInputStream fis2 =new FileInputStream("C:\\Users\\ONE\\Desktop\\微信截图_20210329104422.png");
        FileOutputStream fos = new FileOutputStream("02.png");

        int length ;
        byte[] bytes = new byte[2048];
        while ((length = fis2.read(bytes)) != -1) {
            fos.write(bytes,0,length);
        }
        // tip: 流的关闭原则：先开后关，后开先关。
        fos.close();
        fis2.close();
    }
}
