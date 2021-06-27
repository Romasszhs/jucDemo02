package com.hang.designs.buider.demo01;


/*
* 建造者模式
* 定义： 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
* 主要作用： 在用户不知道对象的建造过程和细节的情况下就可以直接创建复杂的对象
*
* 用户只需要给出指定复杂对象的类型和内容，建造者模式负责按顺序创建复杂对象（把内部的建造细节和过程隐藏起来）
*
*
* */
public class Test {
    public static void main(String[] args) {
        //指挥
        Director director = new Director();
        Product product = director.build(new Worker());
        System.out.println(product.toString());
    }
}
