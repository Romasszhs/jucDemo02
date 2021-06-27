package com.hang.designs.test;

//类的加载  -   类的链接 -  类的初始化
public class Test {
    static {
        System.out.println("Main方法被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1.主动引用（一定会发生类的初始化）
        //Son son = new Son();

        //反射也会产生主动引用
        //Class.forName("com.hang.designs.test.Son");
        /*
            输出：
                Main方法被加载
                父类被加载
                子类被加载
                300
         */

        // 调用类的静态成员（包括静态成员变量和静态方法）
        // 调用静态成员变量
        //System.out.println(Son.m);
        /*
            输出：
                Main方法被加载
                父类被加载
                子类被加载
                300
                300
         */
        // 调用静态方法
        //Son.getName();
        /*
            输出：
                Main方法被加载
                父类被加载
                子类被加载
                300
                hello I am a static method !
         */


        //2.被动引用（不会发生类的初始化）
        //当通过子类引用父类的静态变量，不会导致子类初始化
        //System.out.println(Son.b);
        /*
            输出：
            Main方法被加载
            父类被加载
            2
        */

        // 以下例子不会
        //Son[] array = new Son[5];
        /*
            输出：
            Main方法被加载

        */

        // 调用final常量
        //System.out.println(Son.M);
        /*
        * 输出：
        * Main方法被加载
        * 1
         * */
    }
}

class Father{
    static int b=2;
    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father{
    static int m = 100; // 该行代码置于静态代码块前或者后，有不同的赋值
    // 静态代码块对于定义在它之前的静态变量，可以赋值，也可以访问。
    static {
        System.out.println("子类被加载");
        m = 300;
        System.out.println(m);
    }

    static {
        s = 200;
        // 不能在字段定义前进行访问
        //System.out.println(s);报异常
    }
    // 静态代码块对于定义在它之后的静态变量，可以赋值，但是不能访问.
    // 而且该赋值会被后来的静态变量正式初始化赋值覆盖。
    static int s = 100;
    static final int M = 1;

    static void getName(){
        System.out.println("hello I am a static method ! ");
    }
}
