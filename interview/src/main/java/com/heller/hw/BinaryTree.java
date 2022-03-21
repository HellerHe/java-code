package com.heller.hw;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.*;

public class BinaryTree {
    private int node;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree(int node) {
        this.node = node;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    private void traverse() {
        if (this.left != null) {
            this.left.traverse();
        }
        if (this.right != null) {
            this.right.traverse();
        }
        System.out.println(this.node);
    }

    private BinaryTree search(int num) {
        BinaryTree tmp = null;
        if (this.node == num) {
            return this;
        }
        if (this.left != null) {
            tmp = this.left.search(num);
        }
        if (tmp != null) {
            return tmp;
        }
        if (this.right != null) {
            tmp = this.right.search(num);
        }
        return tmp;
    }

    public static void main(String[] args) {
        BinaryTree node1 = new BinaryTree(1);
        BinaryTree node2 = new BinaryTree(2);
        BinaryTree node3 = new BinaryTree(3);
        BinaryTree node4 = new BinaryTree(4);
        BinaryTree node5 = new BinaryTree(5);
        BinaryTree node6 = new BinaryTree(6);
        BinaryTree node7 = new BinaryTree(7);
        BinaryTree node8 = new BinaryTree(8);
        node6.setLeft(node8);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node1.setLeft(node2);
        node1.setRight(node3);
        node1.traverse();

        System.out.println(node1.search(8).node);
    }
}
