package com.hang.practice;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: hangshuo
 * @date: 2023/12/29 15:52
 * @Description:
 */

public class LC测试queue和deque两种队列的方法 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.offer("ab");
        queue.offer("cd");
        queue.add("ef");

        System.out.println(queue);

        System.out.println(queue.poll());

        Deque<String> deque = new LinkedList<>();
        deque.push("ab");
        deque.push("cd");
        deque.push("ef");

        System.out.println(deque);
        System.out.println(deque.peek());
        System.out.println(deque.pop());


    }
}
