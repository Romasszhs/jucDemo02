package com.hang.fanxin;

/**
 * @author: hangshuo
 * @date: 2021/04/16 17:43
 * @Description:
 */

public class fanxinDemo1 {
    // 泛型方法
    public <MVP> MVP show(MVP mvp){
        System.out.println(mvp.getClass());
        return mvp;
    }

    // 泛型静态方法
    public static  <E> void teach(E e){
        System.out.println(e.getClass());
    }



}
