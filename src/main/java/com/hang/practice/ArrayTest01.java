package com.hang.practice;

import java.util.Random;

public class ArrayTest01 {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random ran = new Random();
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            array[i] = ran.nextInt(100);
            max = Math.max(max, array[i]);
            System.out.print(array[i]+" ");
        }
        System.out.println("最大的数字："+max);

        Integer[] array1 = new Integer[]{1,null,2,null,6,7,8};

        for (Integer integer : array1) {
            System.out.println(integer);
        }
        System.out.println("array1.length: "+array1.length);
    }
}
