package com.hang.designs.factory.factoryfactory;

public class XiaoMiPhone implements MyPhoneProduct {
    @Override
    public void start() {
        System.out.println("开启小米手机");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭小米手机");

    }

    @Override
    public void call() {
        System.out.println("小米手机打电话");

    }

    @Override
    public void sendMessage() {
        System.out.println("小米手机发短信");

    }
}
