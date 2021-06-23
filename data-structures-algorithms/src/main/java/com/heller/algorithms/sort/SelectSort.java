package com.heller.algorithms.sort;

/**
 * ----选择排序 O(n^2)
 * 每次选最小值排前面
 */
public class SelectSort {
    int count = 0;
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min = arr[i];
            int x = i;
            for (int j = i+1; j <arr.length; j++) {
                count++;
                if (min > arr[j]) {
                    min = arr[j];
                    x = j;
                }
            }
            if (x != i) {
                arr[x] = arr[i];
                arr[i] = min;
            }
        }
    }
}
