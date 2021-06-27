package com.hang.designs.factory.factoryfactory;

public class HuaWeiFactory implements ProductFactory {
    @Override
    public MyPhoneProduct phoneProduct() {
        return new HuaWeiPhone();
    }

    @Override
    public RouterProduct routerProduct() {
        return new HuaWeiRouter();
    }
}
