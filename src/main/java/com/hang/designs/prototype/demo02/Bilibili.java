package com.hang.designs.prototype.demo02;


import java.util.Date;

/*
* 客户端： 克隆
* video1  video2  中的date对象指向内存中的同一块地址  所以该方式是  浅克隆(浅拷贝)
*
* 如何深拷贝？？？
* 实现方式：
*           序列化  反序列化
*           改造克隆方法
*
* Spring Bean : 单例模式  原型模式
*       原型模式  +  工厂模式 ==》 new  《==》  原型模式
* */
public class Bilibili {
    public static void main(String[] args) throws Exception {
        //原型对象
        Date date = new Date();
        Video video1 = new Video("小张学习视频", date);
        //video1 被克隆出 video2
        Video video2 = (Video) video1.clone();
        System.out.println("video1=>" + video1);
        System.out.println("video2=>" + video2);
        Date createTime1 = video1.getCreateTime();
        System.out.println("video1 :"+createTime1.hashCode());
        Date createTime2 = video2.getCreateTime();
        System.out.println("video2 :"+createTime2.hashCode());
        //hashCode值相等  也不一定是同一对象地址
        System.out.println(createTime1==createTime2);//false
        System.out.println("=======================");
        date.setTime(21441411);

        System.out.println("video1=>" + video1);
        System.out.println("video2=>" + video2);


    }

}
