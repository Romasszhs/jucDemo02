package com.hang.fileReader;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class test3 {
    public static void main(String[] args) throws IOException {
        ClassPathResource cpr = new ClassPathResource("banner.txt");
        File file = cpr.getFile();

        FileReader reader = new FileReader(file);

        StringBuffer sb =new StringBuffer();
        while (reader.ready()){
            sb.append((char)reader.read());
        }
        System.out.println(sb.toString());

        reader.close();
    }
}
