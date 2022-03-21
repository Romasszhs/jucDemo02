package com.hang.designs.proxy;

/**
 * @author: hangshuo
 * @date: 2021/11/27 22:37
 * @Description:
 */

public class AliSmsService {
    public String send(String message){
        System.out.println("send message: "+ message);

        return message;

    }
}
