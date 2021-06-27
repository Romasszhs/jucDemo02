package com.hang.juc.single;

// enum是一个什么？？？
// 枚举本身也是一个Class类

import java.lang.reflect.Constructor;

public enum EnumSingle {
    INSTANCE;   //自己类型的对象
    public EnumSingle getInstance(){
        return INSTANCE;
    }
}

class Test{
    public static void main(String[] args) throws Exception {
        EnumSingle instance1 = EnumSingle.INSTANCE;
        /*EnumSingle instance2 = EnumSingle.INSTANCE;
        System.out.println(instance1);
        System.out.println(instance2);*/

        //Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor();
        // 运行报错 Exception in thread "main" java.lang.NoSuchMethodException: com.hang.juc.single.EnumSingle.<init>()
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);
        // 运行报错 Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
        declaredConstructor.setAccessible(true);
        EnumSingle instance2 = declaredConstructor.newInstance();
        System.out.println(instance1);
        System.out.println(instance2);
    }
}
// 使用jad -sjava EnumSingle.class   进行反编译
// 出现 EnumSingle.java 代码
// 下面是反编译出来的代码
/*
*
* public final class EnumSingle extends Enum{

    public static EnumSingle[] values()
    {
        return (EnumSingle[])$VALUES.clone();
    }

    public static EnumSingle valueOf(String name)
    {
        return (EnumSingle)Enum.valueOf(com/hang/juc/single/EnumSingle, name);
    }

    private EnumSingle(String s, int i)
    {
        super(s, i);
    }

    public EnumSingle getInstance()
    {
        return INSTANCE;
    }

    public static final EnumSingle INSTANCE;
    private static final EnumSingle $VALUES[];

    static
    {
        INSTANCE = new EnumSingle("INSTANCE", 0);
        $VALUES = (new EnumSingle[] {
            INSTANCE
        });
    }
}

*
* */