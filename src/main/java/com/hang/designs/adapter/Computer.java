package com.hang.designs.adapter;


//客户端类：想上网，插不上网线
public class Computer {
    public void net(NetToUSB adapter){
        //上网的具体实现，找一个转接头
        adapter.handleRequest();
    }
    
}
