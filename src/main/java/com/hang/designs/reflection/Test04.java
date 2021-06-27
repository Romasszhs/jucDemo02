package com.hang.designs.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//动态创建对象，通过反射
public class Test04 {
    public static void main(String[] args) throws Exception {
        Class c = Class.forName("com.hang.reflection.User");

        //创建一个对象
        User user = (User) c.newInstance();//本质上是调用了无参构造器
        System.out.println(user);

        //通过构造器创建对象
        Constructor constructor = c.getConstructor(String.class, int.class, int.class);
        Object zhangsan = constructor.newInstance("zhangsan", 10000, 18);
        System.out.println(zhangsan);


        //操作方法
        //通过反射调用普通方法
        User user1 = (User) c.newInstance();
        //通过反射获取一个方法
        Method setName = c.getDeclaredMethod("setName", String.class);
        //incoke 激活的意思
        //（对象，"方法的值"）
        setName.invoke(user1,"lisi");
        System.out.println(user1.getName());

        //操作字段
        //通过反射操作属性
        Field name = c.getDeclaredField("name");
        name.setAccessible(true);
        name.set(user1,"wangwu");
        System.out.println(user1.getName());
    }
}
