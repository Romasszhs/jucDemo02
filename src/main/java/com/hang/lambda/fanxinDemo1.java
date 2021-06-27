package com.hang.lambda;

/**
 * @author: hangshuo
 * @date: 2021/04/16 17:43
 * @Description:
 */

/*
* 定义含有泛型的方法:泛型定义在方法的修饰符和返回值类型之间
* 含有泛型的方法,在调用方法的时候确定泛型的数据类型
* 传递什么类型的参数,泛型就是什么类型
* */
public class fanxinDemo1 {
    // 定义一个返回值也是泛型的方法
    public <MVP> MVP show(MVP mvp){
        System.out.println(mvp.getClass());
        return mvp;
    }
    //定义一个含有泛型的方法
    public <E> void teach(E e){
        System.out.println(e.getClass());
    }

    //定义一个含有泛型的静态方法
    public static <S> void method02(S s){
        System.out.println(s);
    }
}
