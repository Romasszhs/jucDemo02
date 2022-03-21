package com.hang.practice.getoffer;

/**
 * @author: hangshuo
 * @date: 2021/12/12 16:08
 * @Description:
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺
 * 序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class offer04_2darray {
    public static void main(String[] args) {
        // 不断排除掉 最右边的列和最上边的行 ， 如果剩余矩阵的右上角为target ， 返回true，否则返回false
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target){
        if (matrix.length == 0 || matrix[0].length ==0){
            return false;
        }
        int i = 0 , j = matrix[0].length -1;
        while (j >= 0 && i < matrix.length){
            if (matrix[i][j] > target) j--;
            else if (matrix[i][j] < target) i++;
            else if (matrix[i][j] == target) return  true;
        }
        
        return  false;
    }
}
