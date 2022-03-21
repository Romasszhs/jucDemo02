package com.hang.practice.algorithm;

import com.hang.practice.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: hangshuo
 * @date: 2021/11/28 12:43
 * @Description:
 */

public class SolutionOrderTraversal {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,5,6,2,1};
        TreeNode root = TreeNodeUtil.arrayToTreeNode(array);
        SolutionOrderTraversal solution = new SolutionOrderTraversal();
        //List<Integer> integers = solution.postOrderTraversal(root);
        List<Integer> integers = solution.preOrderTraversal(root);
        System.out.println(integers);

    }


    public List<Integer> postOrderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root==null){
            return res;

        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while(root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root  = stack.pop();
            if (root.right==null || root.right == prev){
                res.add(root.val);
                prev= root;
                root = null;
            }else {
                stack.push(root);
                root = root.right;
            }
        }

        return res;

    }

    public List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<>();
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;

        }

        return res;
    }

    public List<Integer> inOrderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<>();
        while (root!=null || !stack.isEmpty()){
            while (root!=null){

                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;

        }

        return res;
    }

}
