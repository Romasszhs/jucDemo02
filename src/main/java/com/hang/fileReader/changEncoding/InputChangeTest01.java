package com.hang.fileReader.changEncoding;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author: hangshuo
 * @date: 2021/04/21 15:03
 * @Description:
 */

public class InputChangeTest01 {
    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(new FileInputStream("File_GBK.txt"));
        InputStreamReader isr2 = new InputStreamReader(new FileInputStream("File_GBK.txt"),"GBK");

        int read ;
        while ((read = isr.read()) != -1) {
            System.out.println((char)read);
        }
        isr.close();

        while ((read = isr2.read()) != -1) {
            System.out.println((char)read);
        }
        isr2.close();
    }
}
