package com.hang.designs.adapter;

import org.junit.Test;

/*
* 适配器模式
*       将一个类的接口转换成客户希望的另外一个接口。
*       Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以在一起工作
*
* 角色分析
*   目标接口：客户所期待的接口，目标可以是具体的或抽象的类，也可以是接口  在本例中它是NetToUSB接口
*   需要适配的类：需要适配的类或者适配者类。  Adaptee 网线 适配者
*   适配器：通过包装一个需要适配的对象，把原接口转换成目标对象   Adapter适配器
*
*
* */
public class Test01 {

    @Test
    public void test01() {
        Adapter adapter = new Adapter();
        Computer computer = new Computer();
        computer.net(adapter);
    }

    @Test
    public void test02(){
        Computer computer = new Computer();
        Adaptee adaptee = new Adaptee();
        Adapter2 adapter2 = new Adapter2(adaptee);

        computer.net(adapter2);
    }
}
