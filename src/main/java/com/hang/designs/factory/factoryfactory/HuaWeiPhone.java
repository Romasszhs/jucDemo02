package com.hang.designs.factory.factoryfactory;

public class HuaWeiPhone implements MyPhoneProduct {
    @Override
    public void start() {
        System.out.println("开启华为手机");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭华为手机");

    }

    @Override
    public void call() {
        System.out.println("华为手机打电话");

    }

    @Override
    public void sendMessage() {
        System.out.println("华为手机发短信");

    }
}
