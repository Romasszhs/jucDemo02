package com.hang.designs.proxy.demo02;

import org.junit.Test;

public class Demo02 {
    @Test
    public void test01(){
        Seller seller = new Seller();
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setTarget(seller);

        Factory proxy = (Factory) pih.getProxy();
        proxy.sell("笔记本产品");
    }
}
