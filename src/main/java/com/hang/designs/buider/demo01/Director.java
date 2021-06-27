package com.hang.designs.buider.demo01;


//指挥 : 核心， 负责指挥工程的进度顺序
public class Director {

    //指挥工人按照特定顺序建设房子
    public  Product build(Builder builder){
        builder.buildC();
        builder.buildD();
        builder.buildB();
        builder.buildA();
        //这里的
        return builder.getProduct();
    }
}
