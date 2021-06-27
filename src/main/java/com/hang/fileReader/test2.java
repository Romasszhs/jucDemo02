package com.hang.fileReader;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class test2 {
    public static void main(String[] args) throws Exception{
        ClassPathResource cpr = new ClassPathResource("banner.txt");
        File file = cpr.getFile();
        //FileReader fr = new FileReader(file);

        FileInputStream fis = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(fis);

        StringBuffer sb = new StringBuffer();
        while (reader.ready()){
            sb.append((char) reader.read());
        }
        System.out.println(sb.toString());
        reader.close();

        fis.close();
    }
}
