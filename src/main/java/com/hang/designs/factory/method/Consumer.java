package com.hang.designs.factory.method;
/*
* 简单工程模式和工厂方法模式的区别小结：
*
* 简单工厂模式（静态工厂模式）
*   * 虽然某种程度上来说不符合设计原则，但实际使用最多
* 工厂方法模式
*   * 不修改已有类的前提下，通过增加新的工厂类实现扩展
*
*
* */
public class Consumer {
    public static void main(String[] args) throws Exception {
        Car car = new WuLingFactory().getCar();
        car.name();

        Car car1 = new JiLiFactory().getCar();
        car1.name();


    }
}
