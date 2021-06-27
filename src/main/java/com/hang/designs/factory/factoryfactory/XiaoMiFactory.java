package com.hang.designs.factory.factoryfactory;

public class XiaoMiFactory implements ProductFactory {
    @Override
    public MyPhoneProduct phoneProduct() {
        return new XiaoMiPhone();
    }

    @Override
    public RouterProduct routerProduct() {
        return new XiaoMiRouter();
    }
}
