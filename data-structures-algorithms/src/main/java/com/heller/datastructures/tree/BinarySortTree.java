package com.heller.datastructures.tree;

/**
 * ----二叉排序树（BST）
 * 左子节点的值比当前节点的值小，右子节点的值比当前节点的值大
 */
public class BinarySortTree {
    private NumNode root;

    public NumNode create(int[] arr) {
        for (int i : arr) {
            if (root == null) {
                root = new NumNode(i);
            } else {
                root.add(new NumNode(i));
            }
        }
        return root;
    }

    public void del(int num) {
        if (root == null) {
            return;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            root = null;
            return;
        }
        NumNode target = root.binarySortTreeSearch(num);
        if (target == null) {
            return;
        }
        NumNode parent = root.binarySortTreeSearchParent(num);
        if (target.getLeft() == null && target.getRight() == null) {
            //1.删除叶子节点
            if (parent.getLeft() != null && parent.getLeft().getNum() == num) {
                parent.setLeft(null);
            } else if (parent.getRight() != null && parent.getRight().getNum() == num) {
                parent.setRight(null);
            }
        } else if (target.getLeft() != null && target.getRight() != null) {
            //2.删除有两个子树的节点
            NumNode targetRight = target.getRight();
            while (targetRight.getLeft() != null) {
                targetRight = targetRight.getLeft();
            }
            del(targetRight.getNum());
            target.setNum(targetRight.getNum());
        } else {
            //3.删除只有一个子树的节点
            if (target.getLeft() != null) {
                if (parent != null) {
                    if (parent.getLeft().getNum() == num) {
                        parent.setLeft(target.getLeft());
                    } else {
                        parent.setRight(target.getLeft());
                    }
                } else {
                    root = target.getLeft();
                }
            } else {
                if (parent != null) {
                    if (parent.getLeft().getNum() == num) {
                        parent.setLeft(target.getRight());
                    } else {
                        parent.setRight(target.getRight());
                    }
                } else {
                    root = target.getRight();
                }
            }
        }
    }
}
