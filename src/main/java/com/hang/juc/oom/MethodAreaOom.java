package com.hang.juc.oom;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author: hangshuo
 * @date: 2021/04/24 17:40
 * @Description:
 */

public class MethodAreaOom {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        URL url = new File("").toURI().toURL();
        System.out.println(url);
        URL[] urls = new URL[]{url};
        System.out.println(urls);
        ClassLoader loader = new URLClassLoader(urls);
        ClassLoader loader2 = new URLClassLoader(urls);
        // ClassLoader1:java.net.URLClassLoader@e9e54c2
        System.out.println("ClassLoader1:"+loader);
        // ClassLoader2:java.net.URLClassLoader@65ab7765
        System.out.println("ClassLoader2:"+loader2);
        System.out.println("----------------------------------");
        Class<?> loadClass = loader.loadClass(Object.class.getName());
        System.out.println("ClassLoader1加载的第一个Class对象"+loadClass);
        Class<?> loadClass2 = loader2.loadClass(Object.class.getName());
        System.out.println("ClassLoader2加载的第一个Class对象"+loadClass2);
    }
}
