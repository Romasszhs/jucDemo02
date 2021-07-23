package com.hang.designs.reflection;

import org.junit.Test;

import java.io.*;
import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Properties;

@myAnnotation("表的注解")
public class Test07 {

    @myAnnotation(value = "方法的注解")
    public void  test01(@Params("姓名")@RequestParam("请求参数") String name){

    }

    @myAnnotation2(name="zhangsan",age = 18,value = 25)
    public void  test02(){

    }

    @Test
    public void test03() throws Exception {
        Class c = Test07.class;
        // 读取类上的注解 并解析注解属性的内容
        Annotation[] annotations = c.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        // 读取成员方法的注解 并解析注解属性的内容
        System.out.println("----------------------------");
        myAnnotation annotation = (myAnnotation) c.getAnnotation(myAnnotation.class);
        System.out.println(annotation.value());

        Method method = c.getMethod("test01",String.class);
        myAnnotation annotation1 = method.getAnnotation(myAnnotation.class);
        System.out.println(annotation1);
        System.out.println(annotation1.value());
        System.out.println(annotation1.description());

        // 读取成员方法参数的注解  并解析注解属性内容
        System.out.println("----------------------------");
        System.out.println("读取成员方法参数的注解  并解析注解属性内容");
        Parameter[] parameters = method.getParameters();
        Params annotation3 = parameters[0].getAnnotation(Params.class);
        System.out.println(annotation3.value());
        Parameter parameter = parameters[0];
        System.out.println(parameter.getName());

        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (Annotation[] parameterAnnotation : parameterAnnotations) {
            for (Annotation paramAnnotation : parameterAnnotation) {
                System.out.println(paramAnnotation);
            }
        }
        System.out.println("----------------------------");


        Method test02 = c.getMethod("test02");
        myAnnotation2 annotation2 = test02.getAnnotation(myAnnotation2.class);
        System.out.println(annotation2.name());
        System.out.println(annotation2.age());
        System.out.println(annotation2.value());

    }

    // 需求：写一个”框架”,不能改变该类的任何代码的前提下，可以帮我们创建任意类的对象，并且执行其中任意方法
    // 实现： 1.配置文件 application.properties 2.反射
    // 步骤： 1.读取需要的类名和方法名 2.使用反射技术加载类文件进内存 3.创建对象 4.执行方法
    @Test
    public void test04() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, IOException {
        // 方式一：传统方式 使用字符串来存储
        Class<?> aClass = Class.forName("com.hang.designs.reflection.Test07");
        Method test03 = aClass.getMethod("test03");
        //test03.invoke(aClass.newInstance());


        // 方式二：使用配置文件读取文件，获得类名和方法名
        File file = new File("./hello.txt");
        FileReader reader = new FileReader(file);
        BufferedReader reader1 = new BufferedReader(reader);
        String[] strArray = new String[10];
        String line = "";
        strArray[0]  = reader1.readLine();
        strArray[1] = reader1.readLine();
        Class<?> aClass1 = Class.forName(strArray[0]);
        Method method = aClass1.getMethod(strArray[1]);
        method.invoke(aClass1.newInstance());

        // 方式三
        // 使用属性集的方式读取文件
        System.out.println("------------------------------");
        Properties pro = new Properties();
        pro.load(new FileReader("hello.properties"));
        System.out.println(pro.getProperty("classname"));
        System.out.println(pro.getProperty("methodname"));

    }
}



