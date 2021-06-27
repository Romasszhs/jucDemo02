package com.hang.designs.factory.method;

public class JiLiFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new JiLi();
    }
}
