package com.hang.threadwaitnotify;


/**
 * @author: hangshuo
 * @date: 2021/04/18 10:53
 * @Description:
 */

public class MyThreadTest1 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int f = i;
            System.out.println(f);
        }

        ClassLoader loader = MyThreadTest1.class.getClassLoader();

        System.out.println(loader);//sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(loader.getParent());//sun.misc.Launcher$ExtClassLoader@5acf9800
        System.out.println(loader.getParent().getParent());//null

        Zi zi = new Zi(1, "zhangsan");
        System.out.println(zi.toString()+zi.getId());



    }


}
