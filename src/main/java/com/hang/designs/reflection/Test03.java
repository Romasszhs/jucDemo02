package com.hang.designs.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class c = Class.forName("com.hang.reflection.User");

        //获得类的名字
        System.out.println(c.getName());
        System.out.println(c.getSimpleName());

        //获得类的属性
        System.out.println("=============================================");
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        //获取类的方法
        System.out.println("=============================================");
        //获取其与父类的全部public方法
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("=============================================");
        Method[] declaredMethods = c.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        //获得指定方法
        //为什么需要具体方法的参数，因为有方法的重载，存在方法重名
        System.out.println("=============================================");
        Method getName = c.getMethod("getName",null);
        Method setName = c.getMethod("setName", String.class);

        System.out.println(getName);
        System.out.println(setName);


        //获取指定的构造器
        System.out.println("=============================================");
        Constructor[] constructors = c.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        Constructor[] declaredConstructors = c.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        //获取指定的构造器
        System.out.println("=================");
        Constructor constructor = c.getConstructor(String.class, int.class, int.class);
        System.out.println(constructor);
        Constructor constructor1 = c.getConstructor();
        System.out.println(constructor1);
    }
}
