package com.heller.algorithms.sort;

/**
 * ----插入排序 O(n^2)
 * 从无序表中取出第一个元素，插入到有序表中的适当位置
 */
public class InsertSort {
    int count = 0;
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insert = arr[i];
            for (int j = i-1; j >= 0; j--) {
                count++;
                if (insert < arr[j]) {
                    arr[j + 1] = arr[j];
                    arr[j] = insert;
                }
            }
        }
    }
}
