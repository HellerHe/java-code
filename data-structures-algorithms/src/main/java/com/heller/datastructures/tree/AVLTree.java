package com.heller.datastructures.tree;

import javafx.scene.transform.Rotate;

/**
 * ----平衡二叉树（AVL）
 */
public class AVLTree {
    private NumNode root;;


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
            if (parent.getLeft() != null && parent.getLeft().getNum() == num) {
                parent.setLeft(null);
            } else if (parent.getRight() != null && parent.getRight().getNum() == num) {
                parent.setRight(null);
            }
        } else if (target.getLeft() != null && target.getRight() != null) {
            NumNode targetRight = target.getRight();
            while (targetRight.getLeft() != null) {
                targetRight = targetRight.getLeft();
            }
            del(targetRight.getNum());
            target.setNum(targetRight.getNum());
        } else {
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

    public void add(NumNode node) {
        root.addAsAVL(node);
    }

}
