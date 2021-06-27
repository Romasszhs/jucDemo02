package com.hang.Serialization;

import cn.hutool.json.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hang.lambda.Person;

import java.io.File;

/**
 * @author: hangshuo
 * @date: 2021/05/04 19:02
 * @Description:
 */

public class Object2JSON {

    public static void main(String[] args)throws Exception {

        Person person = new Person("lili",24);

        // 1.首先需要一个ObjectMapper对象，序列化和反序列化都需要它。
        ObjectMapper mapper = new ObjectMapper();
        Friend friend = new Friend("yitian", 25);

        // 写为字符串
        String text = mapper.writeValueAsString(friend);
        // 写为文件
        mapper.writeValue(new File("friend.json"), friend);
        // 写为字节流
        byte[] bytes = mapper.writeValueAsBytes(friend);
        System.out.println(text);
        System.out.println(bytes);

        // 从字符串中读取
        Friend newFriend = mapper.readValue(text, Friend.class);
        System.out.println(newFriend);
        // 从字节流中读取
        newFriend = mapper.readValue(bytes, Friend.class);
        System.out.println(newFriend);
        // 从文件中读取
        newFriend = mapper.readValue(new File("friend.json"), Friend.class);
        System.out.println(newFriend);

    }
}
