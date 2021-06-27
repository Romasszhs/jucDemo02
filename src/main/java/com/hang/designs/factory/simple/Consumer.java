package com.hang.designs.factory.simple;

public class Consumer {
    public static void main(String[] args) {
        //使用实现类来获取实例对象
        Car car1 = new WuLing();
        Car car2 = new Tesla();

        car1.name();
        car2.name();

        //使用简单工厂来获取实例对象
        Car car3 = CarFactory.getCar("五菱");
        car3.name();


    }
}
