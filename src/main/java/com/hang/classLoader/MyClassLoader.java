package com.hang.classLoader;

import java.io.*;
import java.net.URLClassLoader;


/**
 * @author: hangshuo
 * @date: 2021/04/28 15:42
 * @Description:
 */

public class MyClassLoader extends ClassLoader{

    private String name;

    public MyClassLoader(ClassLoader parent,String name) {
        super(parent);
        this.name = name;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = getBytes("Test.class");
        Class<?> clazz = this.defineClass(name, data, 0, data.length);
        // defineClass方法的作用
        // Converts an array of bytes into an instance of class <tt>Class</tt>.
        return clazz;
    }

    private byte[] getBytes(String filename)  {
        File file = new File(filename);
        long fileSize = file.length();
        if (fileSize>Integer.MAX_VALUE){
            System.out.println("FILE TOO BIG");
            return null;
        }

        FileInputStream fi = null;
        try {
            fi = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] buffer = new byte[(int)fileSize];
        int offset = 0;
        int numRead = 0;
        try {
            while (offset < buffer.length
                    && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
                offset += numRead;
            }
            // 确保所有数据均被读取
            if (offset != buffer.length) {
                throw new IOException("Could not completely read file " + file.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return buffer;
    }

    /*
    * 测试我们的自定义ClassLoader
    * */
    public static void main(String[] args) {

        System.out.println(ClassLoader.getSystemClassLoader());
        MyClassLoader loader1 = new MyClassLoader(MyClassLoader.class.getClassLoader(),"MyClassLoader");
        try {
            // loadClass方法中
            // 首先
            // First, check if the class has already been loaded查看是否已经被加载
            // Class<?> c = findLoadedClass(name);
            // 接着
            // 会在父加载器中寻求父类加载器加载，父类加载器会在自己的待加载目录查找类的class文件
            // 找不到就往上找父类加载器，直到bootstrap加载器也无法加载
            // 最后
            // 寻求自己的加载器加载，会调用findClass，找到类名.class文件进行加载

            /*
            * 测试前需要将classes文件中对应的class文件删除，让自定义加载器对我们定义的Test类进行加载
            * */
            Class<?> clazz1 = loader1.loadClass("com.hang.classLoader.Test");
            System.out.println(clazz1.getClassLoader());//com.hang.classLoader.MyClassLoader@2cfb4a64
//            sun.misc.Launcher$AppClassLoader@18b4aac2
//            com.hang.classLoader.MyClassLoader@723279cf
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
