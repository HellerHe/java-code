package com.heller.datastructures.tree;

/**
 * ----顺序存储二叉树
 */
public class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        System.out.println(arr[index]);
        if (2 * index + 1 < arr.length) {
            preOrder(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    public void infixOrder(int index) {
        if (2 * index + 1 < arr.length) {
            infixOrder(2 * index + 1);
        }
        System.out.println(arr[index]);
        if (2 * index + 2 < arr.length) {
            infixOrder(2 * index + 2);
        }
    }

    public void suffixOrder(int index) {
        if (2 * index + 1 < arr.length) {
            suffixOrder(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            suffixOrder(2 * index + 2);
        }
        System.out.println(arr[index]);
    }
}
