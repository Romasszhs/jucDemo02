package com.hang.designs.proxy.demo01;

import org.junit.Test;

public class Demo01 {
    @Test
    public void test01(){
        Seller seller = new Seller();
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        proxyInvocationHandler.setFactory(seller);

        Factory proxy = (Factory) proxyInvocationHandler.getProxy();
        proxy.sell("intelCPU");
    }
}
