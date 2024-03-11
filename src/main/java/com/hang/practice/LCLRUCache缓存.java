package com.hang.practice;

import com.google.common.collect.Maps;
import org.apache.commons.collections.map.HashedMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: hangshuo
 * @date: 2023/12/28 9:53
 * @Description:
 */

public class LCLRUCache缓存 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);

        lruCache.put(10,11);
        lruCache.put(11,12);
        lruCache.put(12,13);
        lruCache.put(13,14);
        System.out.println(lruCache.map);
        System.out.println(lruCache.weightMap);

//        System.out.println(lruCache.get(10));
//        System.out.println(lruCache.get(11));
        lruCache.put(16,17);
        lruCache.get(13);
        lruCache.put(12,100);
        lruCache.put(13,null);
        System.out.println(lruCache.map);
        System.out.println(lruCache.weightMap);

        System.out.println(lruCache.map.get(100));
        System.out.println(lruCache.map.get(10));
    }

    static class LRUCache{
        // 必须得使用链表表示权重？  queue？
        // 要有顺序，获取值的方式要满足O（1）
        // 如果再加上  定时过期，则还要满足过期机制
        Map<Integer,Integer> weightMap = new HashMap();
        Map<Integer,Integer> map = new HashMap();
        int capacity = 1;

        public LRUCache(int capacity) {
            this.capacity = capacity;

        }


        public int get(int key){
            // 默认值为-1
            int value = -1;
            if (map.get(key) == null){
                return value;
            }else {
                // 调整缓存顺序，将现在读到的值调整到队列前面
                for (int i = 0; i < weightMap.size(); i++) {
                    Integer integer = weightMap.get(i);
                    if (integer == key){
                        // 将该integer调整到队列最前面
                        // 有点类似冒泡？
                        swap(weightMap,key,i);
                        return map.get(key);
                    }
                }
            }


            return value;
        }

        public void put(int key,Integer value){
            if (Objects.nonNull(map.get(key)) ) {

                // 已存在，将队列排序往前挪
                if (Objects.isNull(value)){
                    map.put(key,-1);

                }else {
                    map.put(key, value);
                }

                swap(weightMap,key,capacity-1);
            }else {
                if (map.size()< capacity){
                    // 存放的位置得从后开始放置，所以要 用容量-已有的数量
                    // 由于下标从0开始，还需进行减1操作
                    weightMap.put(capacity - weightMap.size()-1,key);
                    map.put(key,value);
                }else {
                    // 缓存已满，需要进行替换存储
                    Integer lastOne = weightMap.get(capacity - 1);

                    map.remove(lastOne);
                    swap(weightMap,key,capacity-1);
                    map.put(key,value);
                }
            }

        }

        public void swap(Map weightMap,int key,int number){
            for (int i = 0; i < number; i++) {
                int current = number - i;
                weightMap.put(current,weightMap.get(current-1));
            }
            weightMap.put(0,key);

        }
    }
}
