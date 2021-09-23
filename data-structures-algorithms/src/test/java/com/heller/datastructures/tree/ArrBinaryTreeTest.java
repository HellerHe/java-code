package com.heller.datastructures.tree;


import org.junit.jupiter.api.Test;

public class ArrBinaryTreeTest {
    @Test
    public void order() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree binaryTree = new ArrBinaryTree(arr);
        //binaryTree.preOrder(0);
        //binaryTree.infixOrder(0);
        binaryTree.suffixOrder(0);

    }

    @Test
    public void test() {
        int i = 1;
        i = i++;
        System.out.println(i);
    }
}