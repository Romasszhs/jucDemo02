package com.hang;

import java.util.Scanner;

public class test006 {
     static int[] data = new int[]{1,10,11,15,17};
     static int[] data2 = new int[data.length+1];

     /*
     * 将输入的值插入到相同值的数组索引位置，并进行数组迁移
     *
     * */
    public static void main(String[] args) {
        //System.out.println(data2.length);
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int i1 = Integer.parseInt(s);
        System.out.println(i1);
        System.out.println(data.length);
        // 如果该数值比数组中最大的值都大，将直接插入数组尾；
        if (i1>data[data.length-1]){
            for (int i = 0; i < data.length; i++) {
                data2[i] = data[i];
            }
            data2[data2.length-1]=i1;
            for (int i : data2) {
                System.out.print(i+"  ");
            }
        }else {
            for (int j = 0; j <= data.length-1; j++) {
                if (i1 >= data[j]){
                    add(j,i1);
                }
            }
            for (int i : data2) {
                System.out.print( i+" " );
            }
        }

    }

    public static void add(int index,int e){
        for (int i = data.length-1; i>=index; i--) {
            data2[i+1] = data[i];
        }
        for (int i = 0; i < index; i++) {
            data2[i]=data[i];
        }
        data2[index]=e;
    }
}
