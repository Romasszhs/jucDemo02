package com.hang.designs.bridge;

import org.junit.Test;

/*
* 桥接模式bridge
* 桥接模式是将抽象部分与它的实现部分分离，使它们都可以独立地变化。
*
*
*
* */
public class Test01 {
    @Test
    public void test01(){
        //自己动手组装
        //苹果笔记本
        Computer computer1 = new Laptop(new Apple());
        computer1.info();

        System.out.println("============================");
        //联想台式机
        Computer computer2 = new Desktop(new Lenovo());
        computer2.info();


    }
}
