package com.heller.algorithms.sort;

/**
 * ----冒泡排序 O(n^2)
 * 优化：在一趟排序中，一次交换都没有发生过就终止
 */
public class BubbleSort {
    int count = 0;

    public void sort(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            int max = arr[0];
            for (int j = 1; j < arr.length - i; j++) {
                count++;
                if (arr[j] >= max) {
                    max = arr[j];
                } else {
                    flag = false;
                    arr[j - 1] = arr[j];
                    arr[j] = max;
                }
            }
            //在一趟排序中，一次交换都没有发生过
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }
}
