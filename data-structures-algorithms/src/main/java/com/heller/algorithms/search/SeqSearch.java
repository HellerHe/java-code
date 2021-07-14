package com.heller.algorithms.search;

/**
 * ----线性查找
 */
public class SeqSearch {
    public int search(int[] arr, int value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
