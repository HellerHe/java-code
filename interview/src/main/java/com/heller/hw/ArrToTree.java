package com.heller.hw;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 一维数组转换二叉树
 * root = [3,1,4,3,null,1,5]
 */
public class ArrToTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        Integer[] arr = {3, 1, 4, 3, null, 1, 5};
        ArrToTree arrToTree = new ArrToTree();
        TreeNode tree = arrToTree.to(arr, 1);
        TreeNode treeNode = arrToTree.byQueue(arr);
        System.out.println(tree);
    }

    public TreeNode to(Integer[] arr, int index) {
        if (arr.length < index) {
            return null;
        }
        Integer val = arr[index - 1];
        if (val == null) {
            return null;
        }
        TreeNode tree = new TreeNode(val);
        tree.left = to(arr, 2 * index);
        tree.right = to(arr, 2 * index + 1);
        return tree;
    }

    public TreeNode byQueue(Integer[] arr) {
        TreeNode treeNode = new TreeNode(arr[0]);
        ArrayBlockingQueue<TreeNode> queue = new ArrayBlockingQueue<>(arr.length-1);
        queue.offer(treeNode);
        boolean isleft = true;
        for (int i = 1; i < arr.length; i++) {
            TreeNode root = queue.peek();
            if (isleft) {
                if (arr[i] != null) {
                    root.left = new TreeNode(arr[i]);
                    queue.offer(root.left);
                }
                isleft = false;
            } else {
                if (arr[i] != null) {
                    root.right = new TreeNode(arr[i]);
                    queue.offer(root.right);
                }
                queue.poll();
                isleft = true;
            }
        }
        return treeNode;
    }
}
