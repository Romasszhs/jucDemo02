package com.hang.designs.proxy.demo02;

public class Seller implements Factory {
    @Override
    public void sell(String string) {
        System.out.println("出售"+string+"商品");
    }
}
