package com.hang.designs.reflection;

public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的Class对象
        Class c1 = Class.forName("com.hang.designs.reflection.User");
        System.out.println(c1);

        Class c2 = Class.forName("com.hang.designs.reflection.User");
        Class c3 = Class.forName("com.hang.designs.reflection.User");
        System.out.println(c2==c3);
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
    }
}

