package com.hang.fileReader.changEncoding;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author: hangshuo
 * @date: 2021/04/21 15:41
 * @Description:
 */

// 转换流的示例应用，将gbk编码的文件转换为utf8编码的文件
public class InputOutputChangeEncoding {
    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("File_GBK.txt"),"GBK");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("File_UTF8.txt"),"utf8");

        char[]  chars = new char[2048];
        int len;
        while ((len = isr.read(chars)) != -1) {
            osw.write(new String(chars,0,len));
        }

        osw.close();
        isr.close();
    }
}
