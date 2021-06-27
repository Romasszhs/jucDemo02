package com.hang.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class fileStreamTest {

    public static void main(String[] args) {

        try {
            byte bWrite[]= {11,22,31,44};
            OutputStream os = new FileOutputStream("a.txt");
            for (int i = 0; i < bWrite.length; i++) {
                os.write(bWrite[i]);
            }
            os.close();

            FileInputStream is = new FileInputStream("a.txt");
            int size = is.available();
            for (int i = 0; i < size; i++) {
                System.out.print((char) is.read()+" ");
            }
            is.close();


        }catch (Exception e){
            System.out.println("Exception");
        }
    }
}
