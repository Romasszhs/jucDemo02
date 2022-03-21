package com.hang.designs.adapter;

/**
 * 组合（对象适配器，常用）
 */
//

public class Adapter2 implements NetToUSB {
    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleRequest() {
        adaptee.request();
    }
}
