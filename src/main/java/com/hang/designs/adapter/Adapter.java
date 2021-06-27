package com.hang.designs.adapter;

/*
* 1. 继承（类适配器，单继承）
* 类适配器缺点：
*       由于java不支持多重类继承，一次最多只能适配一个适配者类，不能同时适配多个适配者
*       在java、C#中类适配器模式中的目标抽象类NetToUSB只能为接口，不能为类，其使用有一定的局限性
*
* 2. 组合 （对象适配器，常用）
* 对象适配者优点：
*       一个对象适配器可以把多个不同的适配者适配到同一个目标抽象类中
*       可以适配一个适配者的子类，由于适配器和适配者之间是关联关系，根据里式代换原则，适配者的子类
*       也可以通过该适配器进行适配
*
*
* 此处用的是继承的方式实现
* */


//真正的适配器  需要连接USB,连接网线
public class Adapter extends Adaptee implements NetToUSB {
    @Override
    public void handleRequest() {
        super.request();//可以上网了
    }
}
