package com.heller.datastructures.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HuffmanTreeTest {

    @Test
    void create() {
        int[] arr = { 13, 7, 8, 3, 29, 6, 1 };
        HuffmanTree huffmanTree = new HuffmanTree();
        NumNode numNode = huffmanTree.create(arr);
        numNode.preOrder();
    }
}