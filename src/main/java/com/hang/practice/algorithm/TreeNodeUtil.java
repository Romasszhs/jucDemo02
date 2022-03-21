package com.hang.practice.algorithm;

import com.hang.practice.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: hangshuo
 * @date: 2021/11/28 14:38
 * @Description:
 */

public class TreeNodeUtil {
    public static TreeNode createTreeNode(Integer[] array){
        TreeNode root = createTreeNode(array, 1);
        return root;
    }

    /**
     * @param array (表示要转换的数组)
     * @param index (表示root起点再数组中的位置)
     */
    private static TreeNode createTreeNode(Integer[] array, int index) {
        if(index > array.length){
            return null;
        }
        Integer value = array[index - 1];
        if(value == null){
            return null;
        }
        TreeNode node = new TreeNode(value);
        node.left = createTreeNode(array, index * 2);
        node.right = createTreeNode(array, index * 2 + 1);
        return node;
    }

    public static TreeNode arrayToTreeNode(Integer[] array){
         // 1,null,2,3,4
        if(array.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for(int i = 1; i < array.length; i++){
            TreeNode node = queue.peek();
            if(isLeft){
                if(array[i] != null){
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            }else {
                if(array[i] != null){
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] array =new  Integer[]{1,2,3,4,5};
        arrayToTreeNode(array);

        Integer[] arraytest =new  Integer[]{2,null,4,9,8,null,null,4};
        arrayToTreeNode(arraytest);


    }
}
