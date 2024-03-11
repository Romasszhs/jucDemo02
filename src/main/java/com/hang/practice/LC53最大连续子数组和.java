package com.hang.practice;

/**
 * @author: hangshuo
 * @date: 2023/12/28 9:10
 * @Description:
 */

public class LC53最大连续子数组和 {
    public static void main(String[] args) {
        int[] array = {-1,-2,4,5,6,7,-5};

        int[] array2 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] array3 = {1};

        System.out.println(array.toString());
        System.out.println(array[1]);

        System.out.print("array : ");
        System.out.println(solution(array));
        System.out.print("array2 : ");
        System.out.println(solution(array2));
        System.out.print("array3 : ");
        System.out.println(solution(array3));

    }

    public static Integer solution(int[] array){
        int length = array.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            // 还需求和的次数
            for (int j = i; j < length; j++) {
                int temp = 0;
                if (j>i){
                    temp = calc(i,j,array);
                }else {
                    temp = array[j];
                }

                if (temp> max){
                    max = temp;
                }
            }
        }


        return max;
    }

    public static int calc(int i,int j,int[] array){
        int count = j-i+1;
        int sum = 0;
        for (int i1 = 0; i1 < count; i1++) {
            sum += array[i];
            i++;
        }
        return sum;
    }
}
