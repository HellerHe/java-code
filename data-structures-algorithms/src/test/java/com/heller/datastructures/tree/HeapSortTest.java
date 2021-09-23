package com.heller.datastructures.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {
    @Test
    void sort() {
        int[] arr = {4, 6, 8, 5, 9};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
    }
}