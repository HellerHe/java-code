package com.heller.algorithms.search;

/**
 * ----插值查找
 * 有序数组。提高二分查找效率
 * int mid = left + (right – left) * (findVal – arr[left]) / (arr[right] – arr[left])
 */
public class InsertValueSearch {
    public int search(int[] arr, int left, int right, int value) {
        System.out.println("插值查找");
        if (left > right || value < arr[left] || value > arr[right]) {
            return -1;
        }
        int midIndex = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        if (arr[midIndex] > value) {
            return search(arr, 0, midIndex -1, value);
        } else if (arr[midIndex] < value) {
            return search(arr, midIndex + 1, right, value);
        } else {
            return midIndex;
        }
    }
}
