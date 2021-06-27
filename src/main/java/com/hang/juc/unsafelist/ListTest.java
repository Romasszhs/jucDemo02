package com.hang.juc.unsafelist;


import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

//java.util.ConcurrentModificationException 并发修改异常
public class ListTest {
    public static void main(String[] args) {
        // 并发下ArrayList 不安全的
        /*
        * 解决方案
        * 1. List<String> list = new Vector<>();  不推荐
        * 2. List<String> list = Collections.synchronizedList(new ArrayList<>());
        * 3. List<String> list = new CopyOnWriteArrayList<>();
        * */
        // CopyOnWrite 写入时复制  COW 计算机程序设计领域的一种优化策略
        // 多个线程调用的时候，list，读取的时候，固定的，写入可能会存在覆盖
        // COW 在写入的时候避免覆盖，避免造成数据问题
        // 在写入时复制一份新的数据出来，再进行add
        //
        // 读写分离
        //

        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10; i++) {
            //list.add(UUID.randomUUID().toString().substring(0,5));
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            }).start();
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
