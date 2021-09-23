package com.heller.datastructures.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySortTreeTest {

    @Test
    void create() {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        NumNode root = binarySortTree.create(arr);

        //binarySortTree.del(12);
        //binarySortTree.del(3);
        binarySortTree.del(1);
        root.infixOrder();

    }
}