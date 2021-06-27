package com.hang.designs.factory.factoryfactory;

public class HuaWeiRouter implements RouterProduct {
    @Override
    public void start() {
        System.out.println("打开华为路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭华为路由器");

    }

    @Override
    public void setting() {
        System.out.println("华为路由器 进行设置");

    }

    @Override
    public void wifi() {
        System.out.println("华为路由器 开启wifi");

    }
}
