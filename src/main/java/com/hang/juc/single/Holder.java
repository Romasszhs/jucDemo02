package com.hang.juc.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// 私有静态内部类 实现单例
public class Holder {
    private Holder(){
        System.out.println(Thread.currentThread().getName()+"创建成功");
    }

    private static class InnerClass{
        private static final Holder HOLDER = new Holder();
    }

    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        new Thread(()->{
            Holder ins1 = Holder.getInstance();
            System.out.println(Thread.currentThread().getName()+ins1);
        },"线程A").start();

        /*
        new Thread(()->{
            Holder ins2 = Holder.getInstance();
            System.out.println(ins2);
        },"线程B").start();
        */

//        Class<Holder> aclass = Holder.class;
//        Constructor<Holder> declaredConstructor = aclass.getDeclaredConstructor(null);
//        Holder holder = declaredConstructor.newInstance();
//        System.out.println("通过反射创建的对象："+holder);
        //单例会被反射破坏

    }
}
