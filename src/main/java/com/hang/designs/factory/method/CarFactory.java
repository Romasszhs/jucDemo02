package com.hang.designs.factory.method;

//工厂方法
//将 车工厂也提升为接口，每个车商自己建厂 ，自己生产汽车

public interface CarFactory {
     Car getCar();
}
