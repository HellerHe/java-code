package com.heller.datastructures.tree;

/**
 * ----二叉树
 */
public class BinaryTree {
    private NumNode root;

    public BinaryTree(NumNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (this.root != null) {
            root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void suffixOrder() {
        if (this.root != null) {
            root.suffixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
}
