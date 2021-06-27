package com.hang.designs.proxy.demo01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler {
    private Factory factory;

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),factory.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(factory, args);
        for (Object arg : args) {
            fare((String) arg);
        }
        return result;
    }

    public void fare(String string){
        System.out.println("收取了"+string+"商品的钱");
    }
}
