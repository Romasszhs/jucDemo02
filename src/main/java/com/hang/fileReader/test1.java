package com.hang.fileReader;

import org.springframework.core.io.FileSystemResource;

public class test1 {
    /*
    * FileSystemResource 类介绍
    *
    * */
    public static void main(String[] args) {
        FileSystemResource resource = new FileSystemResource("./");
        System.out.println(resource.getFile().getAbsolutePath());

        FileSystemResource resource2 = new FileSystemResource("/");
        System.out.println(resource2.getFile().getAbsolutePath());
    }
}
