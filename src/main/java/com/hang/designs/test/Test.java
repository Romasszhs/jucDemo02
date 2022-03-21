package com.hang.designs.test;

//类的加载  -   类的链接 -  类的初始化

// 三条前提准则：
/**
 * 1.对于静态字段来说，只有直接定义了该字段的类才会被初始化；
 * 2.当一个类在初始化时，要求其父类全部都已经初始化完毕了；
 * 3.所有Java虚拟机实现必须在每个类或者接口被Java程序“首次主动使用”时才初始化他们
 */
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
        Father father = new Son();
        System.out.println(father.c);
        System.out.println(father.b);
//        System.out.println(father.d); // 报错
//        System.out.println(father.getSomething()); // 报错
        Father.getName();
    }
}

class Father{
    static int b=2;
    int c =4;
    static {
        System.out.println("父类被加载");
    }

    static void getName() {
        System.out.println("hello I am a static method ! ");
    }

    public void getSomething(){}
}

class Son extends Father{
    static int b =3;
    int c =5;
    int d = 6;
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
    // final常量在编译期间会存入到调用这个常量的方法所在的类的常量池中
    // 本质上，调用类并没有直接用用到定义常量的类，因此并不会触发定义常量的类的初始化。
    static final int M = 1;

    static void getName(){
        System.out.println("hello I am a static method ! SON ");
    }
}
