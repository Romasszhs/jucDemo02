package com.hang.juc.oom;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: hangshuo
 * @date: 2021/04/24 17:49
 * @Description:
 */

public class MethodAreaOom1 {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        URL url = new File("").toURI().toURL();
        URL[] urls = new URL[]{url};
        while (true) {
            ClassLoader loader = new URLClassLoader(urls);
            Class<?> loadClass = loader.loadClass(Object.class.getName());
            classes.add(loadClass);
        }
    }
}
