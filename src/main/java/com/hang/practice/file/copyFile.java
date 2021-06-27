package com.hang.practice.file;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author: hangshuo
 * @date: 2021/05/19 14:22
 * @Description:
 */

public class copyFile {
    public static void main(String[] args) throws Exception {
        FileInputStream fis =new FileInputStream("a.txt");
        FileOutputStream fos = new FileOutputStream("b.txt");

        int length ;
        byte[] bytes = new byte[2048];
        while ((length = fis.read(bytes)) != -1) {
            fos.write(bytes,0,length);
        }
        // tip: 流的关闭原则：先开后关，后开先关。
        fos.close();
        fis.close();
    }
}
