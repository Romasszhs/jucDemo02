package com.hang.designs.reflection;


import org.junit.Test;

import java.lang.reflect.Method;

//分析性能问题
public class Test05 {
    //普通方式调用
    public static void test01(){
        User user = new User();
        int i=0;
        long startTime = System.currentTimeMillis();

        for (i = 0; i < 1000000000; i++) {
            user.getName();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("普通方式执行10亿次"+(endTime-startTime)+"ms");
    }

    //反射方式调用
    public static void test02() throws Exception {
        User user = new User();

        long startTime = System.currentTimeMillis();

        Class c = Class.forName("com.hang.designs.reflection.User");
        Method getName = c.getMethod("getName");


        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("反射方式执行10亿次"+(endTime-startTime)+"ms");

    }

    //反射方式调用
    public static void test03() throws Exception {
        User user = new User();

        long startTime = System.currentTimeMillis();

        Class c = Class.forName("com.hang.designs.reflection.User");
        Method getName = c.getMethod("getName");
        getName.setAccessible(true);

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("反射方式并取消java权限检查执行10亿次"+(endTime-startTime)+"ms");

    }

    @Test
    public void test04() throws Exception {
        test01();
        test02();
        test03();
    }

}
