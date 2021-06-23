package com.heller.algorithms.sort;

/**
 * ----快速排序
 */
public class QuickSort {
    public void sort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int tmp = 0;
        while (l < r) {
            //一直找到左边大于pivot的位置
            while (arr[l] < pivot) {
                ++l;
            }
            //一直找到右边小于pivot的位置
            while (arr[r] > pivot) {
                --r;
            }
            if (l >= r) {
                break;
            }
            tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;

            if (arr[l] == pivot) {
                --r;
            }
            if (arr[r] == pivot) {
                ++l;
            }
        }
        if (l == r) {
            ++l;
            --r;
        }
        if (left < r) {
            sort(arr, left, r);
        }
        if (right > l) {
            sort(arr, l, right);
        }
    }
}
