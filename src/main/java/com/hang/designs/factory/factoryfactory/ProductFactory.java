package com.hang.designs.factory.factoryfactory;

//抽象产品工厂
public interface ProductFactory      {
    //生产手机
    MyPhoneProduct phoneProduct();
    //生产路由器
    RouterProduct routerProduct();
}
