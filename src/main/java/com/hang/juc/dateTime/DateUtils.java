package com.hang.juc.dateTime;

import com.hang.designs.bridge.Brand;

import java.time.Instant;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: hangshuo
 * @date: 2021/04/26 11:24
 * @Description:
 */

public class DateUtils {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    /**
    * 这是文档注释
    */
    /*
    * 这是多行注释
    * */
    public static void main(String[] args) {
        String str = "123456";
        threadLocal.set(str);

        System.out.println(threadLocal.get());

        new Thread(()->{
            threadLocal.set("567890");
            System.out.println(Thread.currentThread().getName()+"  "+threadLocal.get());
            threadLocal.remove();
        },"线程A").start();

        ThreadLocalRandom current = ThreadLocalRandom.current();
        long l = current.nextLong(0,10000);
        System.out.println(l);


        switch (str){
            case "123":
                System.out.println("123");
                break;
            case ("123456"):
                System.out.println("这是一个str: "+str);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + str);
        }

        method(null);
        method("123");
    }

    /**
     * 这是测试switch的方法
     * @param param
     * @return String
     * @exception NullPointerException
     */
    public static String method(String param){
        // TODO:
        Optional<String> stringOptional = Optional.ofNullable(param);
        if (stringOptional.isPresent()) {

            switch (stringOptional.get()){
                case "null":
                    System.out.println("null");
                    break;

                case "123":
                    System.out.println("调用成功，参数为："+stringOptional.get());
                    break;
                default:
                    System.out.println("default");
            }
        }
        return "";
    }
}
