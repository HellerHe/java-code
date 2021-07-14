package com.heller.algorithms.sort;

/**
 * ----基数排序
 * 通过键值的各个位的值，将要排序的元素分配至某些“桶”中，达到排序的作用
 */
public class RadixSort {
    public void sort(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLen = String.valueOf(max).length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[10];
        for (int i = 0, n = 1; i < maxLen; i++, n*=10) {
            for (int j = 0; j < arr.length; j++) {
                int digit = arr[j] / n % 10;
                bucket[digit][bucketCount[digit]] = arr[j];
                bucketCount[digit]++;
            }
            //遍历每一桶，并将桶中是数据，放入到原数组
            int index = 0;
            for (int k = 0; k < bucketCount.length; k++) {
                if (bucketCount[k] != 0) {
                    for (int l = 0; l < bucketCount[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketCount[k] = 0;
            }
        }
    }
}
