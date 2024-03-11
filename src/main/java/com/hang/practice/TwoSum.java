package com.hang.practice;


import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * @author ONE
 */
public class TwoSum {
    public static void main(String[] args) {
        Integer[] array = {1,2,4,3,5};
        int target = 8;
        HashMap<Integer, Integer> indexs = Maps.newHashMap();

        for (int i =0  ;i < array.length; i++) {
            indexs.put(array[i],i);
        }
        // 数据结构为  key为数值   value为下标位置
        for (int i = 0; i < array.length; i++) {
            int left = target - array[i];
            if ( indexs.get(left)!= null && indexs.get(left)!=i ){
                System.out.println("target: "+target);
                System.out.println("index: "+i + " and " + indexs.get(left));
                System.out.println("num: " + array[i] + " and "+ left);
                break;
            }
        }

    }
}