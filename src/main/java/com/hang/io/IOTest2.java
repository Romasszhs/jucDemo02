package com.hang.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IOTest2 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = null;
        do {
            str = bufferedReader.readLine();
            System.out.println(str);
        }while (!str.equals("end"));

    }
}
