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

    //添加节点生成顺序二叉树
    public void add(NumNode node) {
        if (node.getNum() < this.num) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    //顺序二叉树查找
    public NumNode binarySortTreeSearch(int num) {
        if (this.num == num) {
            return this;
        } else if (this.num > num) {
            if (this.left == null) {
                return null;
            }
            return this.left.binarySortTreeSearch(num);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.binarySortTreeSearch(num);
        }
    }

    //顺序二叉树父节点查找
    public NumNode binarySortTreeSearchParent(int num) {
        if ((this.left != null && this.left.num == num) || (this.right != null && this.right.num == num)) {
            return this;
        }
        if (this.num > num && this.left != null) {
            return this.left.binarySortTreeSearchParent(num);
        } else if (this.num < num && this.right != null) {
            return this.right.binarySortTreeSearchParent(num);
        } else {
            return null;
        }
    }

    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    private void leftRotate() {
        NumNode newNode = new NumNode(num);
        newNode.left = left;
        newNode.right = right.left;
        num = right.num;
        right = right.right;
        left = newNode;
    }

    private void rightRotate() {
        NumNode newNode = new NumNode(num);
        newNode.right = right;
        newNode.left = left.right;
        num = left.num;
        left = left.left;
        right = newNode;
    }
    //添加节点生成顺序二叉树
    public void addAsAVL(NumNode node) {
        if (this.num > node.num) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.addAsAVL(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.addAsAVL(node);
            }
        }
        //左旋转
        if (right.height() - left.height() > 1) {
            if (right != null && right.left.height() > right.right.height()) {
                right.rightRotate();
                leftRotate();
            } else {
                leftRotate();
            }
            return;
        }
        //右旋转
        if (right.height() - left.height() < 1) {
            if (left != null && left.right.height() > left.left.height()) {
                left.leftRotate();
                rightRotate();
            } else {
                rightRotate();
            }
        }
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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
