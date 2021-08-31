package com.heller.datastructures.tree;

public class NumNode {
    private int num;
    private NumNode left;
    private NumNode right;

    public NumNode(int num) {
        this.num = num;
    }
    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void suffixOrder() {
        if (this.left != null) {
            this.left.suffixOrder();
        }
        if (this.right != null) {
            this.right.suffixOrder();
        }
        System.out.println(this);
    }
    //前序查找
    public NumNode preOrderSearch(int num) {
        System.out.println("进入前序查找。");
        if (this.num == num) {
            return this;
        }
        NumNode tmp = null;
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
    //中序查找
    public NumNode infixOrderSearch(int num) {
        NumNode tmp = null;
        if (this.left != null) {
            tmp = this.left.infixOrderSearch(num);
        }
        if (tmp != null) {
            return tmp;
        }
        System.out.println("进入中序查找。");
        if (this.num == num) {
            return this;
        }
        if (this.right != null) {
            tmp = this.right.infixOrderSearch(num);
        }
        return tmp;
    }
    //后序查找
    public NumNode suffixOrderSearch(int num) {
        NumNode tmp = null;
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
        System.out.println("进入后序查找。");
        if (this.num == num) {
            return this;
        }
        return tmp;
    }

    //删除节点
    public void del(int num) {
        if (this.left != null && this.left.num == num) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.num == num) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.del(num);
        }
        if (this.right != null) {
            this.right.del(num);
        }
    }

    public NumNode getLeft() {
        return left;
    }

    public void setLeft(NumNode left) {
        this.left = left;
    }

    public NumNode getRight() {
        return right;
    }

    public void setRight(NumNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "NumNode{" +
                "num=" + num +
                '}';
    }
}
