package com.hang.fileReader;

import org.springframework.core.io.FileSystemResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class test4 {
    public static void main(String[] args) throws Exception {
        /* 在编译器层面  \\等于/  */
        /* 在计算机层面   windows中  \反斜杠是路径间隔符号*/
        /*  Linus中 /斜杠是路径间隔符号 */
        /*  . 英文句号是代表当前项目路径下的文件相对地址 */
        FileSystemResource resource = new FileSystemResource(".\\server\\src\\main\\resources\\banner.txt");
        File file = resource.getFile();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line =null;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
    }
}
