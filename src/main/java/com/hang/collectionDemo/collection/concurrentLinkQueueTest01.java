package com.hang.collectionDemo.collection;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author: hangshuo
 * @date: 2022/03/03 22:44
 * @Description:
 */

public class concurrentLinkQueueTest01 {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> strings = new ConcurrentLinkedQueue<>();
        strings.offer("a");
        strings.offer("b");
        strings.offer("c");

        System.out.println(strings.poll());
        System.out.println(strings.peek());
        System.out.println(strings.peek());

    }
}
