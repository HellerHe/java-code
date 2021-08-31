package com.heller.datastructures.tree;

import org.junit.jupiter.api.Test;

public class BinaryTreeTest {

    class Node{
        private int num;
        public Node left;
        public Node right;

        public Node(int num) {
            this.num = num;
        }

        private void preOrder() {
            System.out.println(this.num);
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.right.preOrder();
            }
        }

        private void infixOrder() {
            if (this.left != null) {
                this.left.infixOrder();
            }
            System.out.println(this.num);
            if (this.right != null) {
                this.right.infixOrder();
            }
        }

        private void suffixOrder() {
            if (this.left != null) {
                this.left.suffixOrder();
            }
            if (this.right != null) {
                this.right.suffixOrder();
            }
            System.out.println(this.num);
        }

        private Node preOrderSearch(int num) {
            if (this.num == num) {
                return this;
            }
            Node tmp = null;
            if (this.left != null) {
                tmp = this.left.preOrderSearch(num);
            }
            if (tmp != null) {
                return tmp;
            }
            if (this.right != null) {
                tmp = this.right.preOrderSearch(num);
            }
            return tmp;
        }

        public Node infixOrderSearch(int num) {
            Node tmp = null;
            if (this.left != null) {
                tmp = this.left.infixOrderSearch(num);
            }
            if (tmp != null) {
                return tmp;
            }
            if (this.num == num) {
                return this;
            }
            if (this.right != null) {
                tmp = this.right.infixOrderSearch(num);
            }
            return tmp;
        }

        public Node suffixOrderSearch(int num) {
            Node tmp = null;
            if (this.left != null) {
                tmp = this.left.suffixOrderSearch(num);
            }
            if (tmp != null) {
                return tmp;
            }
            if (this.right != null) {
                tmp = this.right.suffixOrderSearch(num);
            }
            if (tmp != null) {
                return tmp;
            }
            if (this.num == num) {
                return this;
            }
            return tmp;
        }
    }

    @Test
    public void order() {
        NumNode root = new NumNode(1);
        NumNode node1 = new NumNode(2);
        NumNode node2 = new NumNode(3);
        NumNode node3 = new NumNode(4);
        NumNode node4 = new NumNode(5);
        NumNode node5 = new NumNode(6);
        NumNode node6 = new NumNode(7);

        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        root.preOrder();
        //root.infixOrder();
        //root.suffixOrder();
        //NumNode numNode = root.preOrderSearch(6);
        //NumNode numNode = root.infixOrderSearch(6);
        //NumNode numNode = root.suffixOrderSearch(6);
        //System.out.println(numNode);
        root.del(3);
        root.preOrder();
    }

    @Test
    public void test() {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;
        //root.preOrder();
        //root.infixOrder();
        //root.suffixOrder();
        //Node node = root.preOrderSearch(2);
        //Node node = root.infixOrderSearch(2);
        Node node = root.suffixOrderSearch(2);
        System.out.println(node);
    }

}