package com.hang.fileReader;

import java.io.File;
import java.io.FileReader;

public class test5 {
    public static void main(String[] args) throws Exception {
        File file = new File("./hello.txt");
        FileReader fileReader = new FileReader(file);
        StringBuffer sb = new StringBuffer();
        while (fileReader.ready()) {
            sb.append((char)fileReader.read());
        }
        System.out.println(sb.toString());
    }


}
