package com.hang.practice;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: hangshuo
 * @date: 2024/01/02 9:51
 * @Description:
 */

public class 牛客twosum {
    public static void main(String[] args) {
        int[] ints = {5, 4, 5, 6, 10};

        牛客twosum twosum = new 牛客twosum();
        int[] result = twosum.twoSum(ints, 10);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int[] result = null;
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target-numbers[i])&& i != map.get(target-numbers[i]) && numbers[i]!= target-numbers[i]){
                 result = new int[]{i +1, map.get(target - numbers[i])+1};
                Arrays.sort(result);
                return result;
            }else {
                map.put(numbers[i],i);
            }
        }
        return result;
    }
}
