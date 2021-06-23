package com.heller.algorithms.sort;

/**
 * ----希尔排序
 * 简单插入排序更高效的版本，缩小增量排序
 */
public class ShellSort {
    public void changeSort(int[] arr) {
        for (int gap = arr.length/2; gap > 0; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i-gap; j >=0 ; j-=gap) {
                    if (arr[j] > arr[j + gap]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = tmp;
                    }
                }
            }
        }
    }

    public void moveSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i <arr.length; i++) {
                for (int j = i; j-gap >= 0; j -= gap) {
                    int min = arr[j];
                    if (min < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        arr[j - gap] = min;
                    }
                }
            }
        }
    }
}
