package com.hang.designs.reflection;



public class Test02 {

    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器---》扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类加载器---》根加载器（c/c++）
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类是由哪个加载器加载的
        ClassLoader classLoader1 = Class.forName("com.hang.reflection.Test02").getClassLoader();
        System.out.println(classLoader1);

        //测试类库中的类是什么加载器加载的
        ClassLoader classLoader2 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader2);

        //测试lib中的类是什么加载器加载的
        ClassLoader classLoader3 = Class.forName("org.junit.Test").getClassLoader();
        System.out.println(classLoader3);

        //如何获取系统类加载器可以加载的路径
        //System.out.println(System.getProperty("java.class.path"));
        String[] split = System.getProperty("java.class.path").split(";");
        for (String s : split) {
            System.out.println(s);
        }
    }
}
