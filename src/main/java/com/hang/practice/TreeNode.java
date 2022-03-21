package com.hang.practice;

/**
 * @author: hangshuo
 * @date: 2021/10/16 15:33
 * @Description:
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(){}

    public TreeNode(int val){
        this.val = val;
    }

    TreeNode(int val,TreeNode left , TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;

    }

    TreeNode createBinaryTreeByArray(Integer[] arr ){
        TreeNode root = new TreeNode(arr[0]);
//        arr.length

        return null;
    }
}
