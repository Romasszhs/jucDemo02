package com.hang.juc.future;

import java.util.concurrent.Callable;

/**
 * @author: hangshuo
 * @date: 2021/04/22 17:24
 * @Description:
 */

public class TestCallable1 implements Callable<String> {
    private String name;

    public TestCallable1(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println("调用Callable的call()方法进行逻辑处理开始");
        return name;
    }
}
