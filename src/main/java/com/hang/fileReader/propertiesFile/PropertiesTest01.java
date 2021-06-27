package com.hang.fileReader.propertiesFile;

import java.io.FileReader;
import java.util.Properties;

/**
 * @author: hangshuo
 * @date: 2021/04/21 16:09
 * @Description:
 */

public class PropertiesTest01 {
    public static void main(String[] args) throws Exception{
        Properties pro = new Properties();
        pro.load(new FileReader("hello.properties"));
        System.out.println(pro.getProperty("classname"));
    }
}
