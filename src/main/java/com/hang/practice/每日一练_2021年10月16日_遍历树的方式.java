package com.hang.practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 递归算法就是调整print的位置完成 tree的遍历
 * 使用迭代来完成
 * @author: hangshuo
 * @date: 2021/10/16 15:15
 * @Description:
 */

public class 每日一练_2021年10月16日_遍历树的方式 {
    @Test
    public void binaryTreeInorderTraversalTest() {
        Integer arr[] = { 1, 2, 3, 4, 5, 6 };
        TreeNode root = new TreeNode();
        root.val = 1;

        List<Integer> list = inorderTraversal2(root);
        Assert.assertEquals(list.size(), 6);
    }

//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root == null) {
//            return new ArrayList<>();
//        }
//        List<Integer> inorderList = new ArrayList<>();
//        inorderHelper(inorderList, root);
//        return inorderList;
//    }
//
//    public void inorderHelper(List<Integer> inorderList, TreeNode root) {
//        if (root.left != null) {
//            inorderHelper(inorderList, root.left);
//        }
//        inorderList.add(root.val);
//        if (root.right != null) {
//            inorderHelper(inorderList, root.right);
//        }
//    }
    // 前序遍历
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root == null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            resultList.add(node.val);
            root = node.right;
        }
        return resultList;
    }

}


