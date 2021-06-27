package com.hang.juc.stream;


import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        User u1 = new User(1,"a",22);
        User u2 = new User(2,"d",22);
        User u3 = new User(3,"c",22);
        User u4 = new User(4,"b",22);

        //集合就是存储
        List<User> list = Arrays.asList(u1, u2, u3, u4);

        /*
        * 题目：
        * 现在有四个用户！筛选
        * 1.ID必须是偶数
        * 2.年龄必须大于23岁
        * 3.用户名转为大写字母
        * 4.用户名字母倒着排序
        * 5.只输出一个用户
        *
        * */
        //计算交给Stream
        list.stream()
                .filter((u)->{ return u.getId()%2==0; })
                .map((u)->{ return  u.getName().toUpperCase();}).sorted( (user1,user2)->{ return user1.compareTo(user2);} )
                //.limit(1)
                .forEach(System.out::println);

    }
}
