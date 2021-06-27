package com.hang.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IOTest1 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char a ;
        do {
            a = (char) bufferedReader.read();
            System.out.println(a);
        }while (a!='q');
    }
}
