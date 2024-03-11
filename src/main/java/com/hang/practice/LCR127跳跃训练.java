package com.hang.practice;

/**
 * @author: hangshuo
 * @date: 2024/01/02 14:30
 * @Description:
 */

public class LCR127跳跃训练 {
    public static void main(String[] args) {
        LCR127跳跃训练 jumpPerson = new LCR127跳跃训练();
        System.out.println(jumpPerson.jump(4));
    }

    public int jump(int num){
        if (num == 0 || num ==1){
            return 1;
        }
        return jump(num-1) + jump(num-2);
    }
}
