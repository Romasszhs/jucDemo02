package com.hang.practice;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: hangshuo
 * @date: 2023/12/28 9:53
 * @Description:
 */

public class LCLRUCache缓存DLink {
    public static void main(String[] args) {
        LRUCacheDLink lruCacheDLink = new LRUCacheDLink(3);
        lruCacheDLink.put(1,10);
        lruCacheDLink.put(2,20);
        lruCacheDLink.put(3,30);
        lruCacheDLink.put(2,60);
        lruCacheDLink.put(4,30);
        System.out.println(lruCacheDLink.get(1));
        System.out.println(lruCacheDLink.get(2));
        System.out.println(lruCacheDLink.get(4));



    }

    static class LRUCacheDLink{
        class DLinkedNode{
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;

            public DLinkedNode() {
            }

            public DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }


        }

        // 必须得使用链表表示权重？  queue？
        // 要有顺序，获取值的方式要满足O（1）
        // 如果再加上  定时过期，则还要满足过期机制
        private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;


        public LRUCacheDLink(int capacity) {
            this.size = 0;
            this.capacity = capacity;

            // 使用虚拟头部和虚拟尾部节点
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }


        public int get(int key){
            // 获取得到值
            // 通过双向链表删除原节点，加入头部
            // 获取不到值，返回默认值-1
            int value = -1;
            DLinkedNode dLinkedNode = cache.get(key);
            if (dLinkedNode == null){
                return value;
            }
            // 调整缓存顺序，将现在读到的值调整到队列前面
            moveToHead(dLinkedNode);
            value = dLinkedNode.value;
            return value;
        }

        public void put(int key,Integer value){
            DLinkedNode currentNode = cache.get(key);
            if (Objects.isNull(currentNode)) {

                // 存放的位置得从后开始放置，所以要 用容量-已有的数量
                // 由于下标从0开始，还需进行减1操作
                DLinkedNode newNode = new DLinkedNode(key,value);
                cache.put(key,newNode);
                addToHead(newNode);
                ++size;
                if(size>capacity){

                    DLinkedNode lastnode = removeTail();
                    cache.remove(lastnode.key);
                    --size;
                }
            }else {
                currentNode.value = value;
                moveToHead(currentNode);
            }

        }

        void moveToHead(DLinkedNode node){
            removeNode(node);
            addToHead(node);
        }

        void removeNode(DLinkedNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        void addToHead(DLinkedNode node){
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        DLinkedNode removeTail(){
            DLinkedNode lastNode = tail.prev;
            removeNode(lastNode);
            return lastNode;
        }

    }
}
