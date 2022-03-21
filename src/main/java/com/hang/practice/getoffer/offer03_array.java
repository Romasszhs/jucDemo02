package com.hang.practice.getoffer;

/**
 * @author: hangshuo
 * @date: 2021/12/12 15:20
 * @Description:
 */

public class offer03_array {
    public static void main(String[] args) {
        /**
         * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
         *
         *
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
    }

    public static int findRepeatNumber(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num==i) continue;
            if (nums[num] == num ) return num;

            // 循环置位：
            // 将当前i位置上的数放置到它应该去的位置 譬如nums[0]存放的是3，将其存放到nums[3]=3
            // 置换出来的
            while (nums[i]!=i){
                // i下标位置上数应该发往 nums[i]下标位置，置换出num这个数
                num = nums[nums[i]]; // 置换出来的数暂时存放在num中
                if (num==nums[i]) return num; // 发现恰好和要置换的位置的数相同，找到重复的数啦
                nums[nums[i]] = nums[i]; // 开始置换
                nums[i] = num; //
            }


        }
        return -1;
    }
}
