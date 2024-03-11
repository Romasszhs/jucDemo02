package com.hang.practice.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * LC119寻找最长的连续子串的方法
 * @author: hangshuo
 * @date: 2021/11/28 17:03
 * @Description:
 */

public class lc119最长的连续子串 {
    public static int longestConsecutive(Integer[] nums){
        Set<Integer> set = new HashSet<>();

        for (Integer num : nums) {
            set.add(num);
        }

        int longest = 1;
        int current = 1;
        for (Integer num : set) {
            if (!set.contains(num-1)){
                int number = num;
                while (set.contains(number+1)){
                    current+=1;
                    number+=1;
                }
                if (current>longest){
                    longest = current;
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {

        Integer[] array = new Integer[]{100,4,200,1,3,2};
        Integer[] arraytest2 = new Integer[]{0,3,7,2,5,8,4,6,0,1};

        int i = longestConsecutive(array);
        System.out.println(i);

        int i1 = longestConsecutive(arraytest2);
        System.out.println(i1);
    }
}
