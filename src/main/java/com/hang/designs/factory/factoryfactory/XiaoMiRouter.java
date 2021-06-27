package com.hang.designs.factory.factoryfactory;

public class XiaoMiRouter implements RouterProduct {
    @Override
    public void start() {
        System.out.println("开启小米路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭小米路由器");

    }

    @Override
    public void setting() {
        System.out.println("小米路由器 进行设置");

    }

    @Override
    public void wifi() {
        System.out.println("小米路由器 打开wifi");

    }
}
