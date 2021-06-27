package com.hang.io;

import java.io.IOException;

public class IOTest3 {
    public static void main(String[] args) throws IOException {
        int b ;
        byte[] bytes = {11,21,33,42};
        b='a';
        System.out.write(b);
        System.out.write('\n');
        System.out.write(bytes);


    }
}
