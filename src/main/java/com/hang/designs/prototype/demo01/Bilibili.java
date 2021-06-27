package com.hang.designs.prototype.demo01;


import java.util.Date;

/*
* 客户端： 克隆
* video1  video2  中的date对象指向内存中的同一块地址  所以该方式是  浅克隆(浅拷贝)
*
* 如何深拷贝？？？
* 实现方式：
*           序列化  反序列化
*           改造克隆方法
* */
public class Bilibili {
    public static void main(String[] args) throws Exception {
        //原型对象
        Date date = new Date();
        Video video1 = new Video("小张学习视频", date);
        System.out.println("video1=>" + video1);
        System.out.println("video1=>" + video1.hashCode());
        Date createTime1 = video1.getCreateTime();
        System.out.println(createTime1.hashCode());

        System.out.println("=======================");
        //date对象被改变  指向同一内存地址的  克隆对象  和 被克隆对象 的date对象同时也被修改
        date.setTime(222222222);

        //video1 被克隆出 video2
        Video video2 = (Video) video1.clone();
        System.out.println("video2=>" + video2);
        System.out.println("video2=>" + video2.hashCode());


        video2.setName("克隆的小张学习视频");
        System.out.println("video2=>" + video2);
        System.out.println("video2=>" + video2.hashCode());
        Date createTime2 = video2.getCreateTime();
        System.out.println(createTime2.hashCode());

        System.out.println("=======================");
        System.out.println("video1=>" + video1);
        System.out.println("video1=>" + video1.hashCode());
        createTime1 = video1.getCreateTime();
        System.out.println(createTime1.hashCode());
    }

}
