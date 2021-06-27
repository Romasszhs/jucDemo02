package com.hang.fileReader;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class test {
    public static void main(String[] args) throws Exception {
        ClassPathResource classPathResource = new ClassPathResource("statics/js/index.js");
        File file = classPathResource.getFile();
        System.out.println(file.getAbsolutePath());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();

        String line =null;
        while ((line = bufferedReader.readLine())!=null){
            sb.append(line);
        }

        System.out.println(sb.toString());








    }
}
