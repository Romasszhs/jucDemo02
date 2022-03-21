package com.hang.designs.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 自定义 MethodInterceptor
 * @author: hangshuo
 * @date: 2021/11/27 22:41
 * @Description:
 */

public class DebugMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 调用方法之前，我们可以添加自己的操作
        System.out.println();
        // 调用方法之后，我们同样可以添加自己的操作

        return null;
    }
}
