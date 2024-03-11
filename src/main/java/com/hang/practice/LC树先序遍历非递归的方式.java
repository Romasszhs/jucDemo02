package com.hang.practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @author: hangshuo
 * @date: 2023/12/28 17:30
 * @Description:
 */

public class LC树先序遍历非递归的方式 {
    public static void main(String[] args) {
        treeNode listNode1 = new treeNode(1);
        treeNode listNode2 = new treeNode(2);
        treeNode listNode3 = new treeNode(3);
        treeNode listNode4 = new treeNode(4);
        treeNode listNode5 = new treeNode(5);
        treeNode listNode6 = new treeNode(6);
        listNode1.right = listNode2;

        listNode1.left = listNode3;

        listNode2.right = listNode4;

        listNode4.right = listNode5;

        listNode3.left = listNode6;



    }



    public static List<Integer> preSolution(treeNode root){

        Deque stack = new LinkedList();
        List<Integer> result = new ArrayList<>();

        return result;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class  treeNode{
         int value;

        treeNode right;
        treeNode left;

        public treeNode(int value) {
            this.value = value;
        }
    }

}
