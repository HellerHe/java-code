package com.heller.algorithms.sort;

/**
 * ----归并排序
 * 分治策略
 */
public class MergeSort {
    public void sort(int[] arr, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, tmp);
            sort(arr, mid + 1, right, tmp);
            merge(arr, left, mid, right, tmp);
        }
    }

    public void merge(int[] arr, int left, int mid, int right, int[] tmp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        //先把左右两边(有序)的数据按照规则填充到 temp 数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                tmp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                tmp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        //把有剩余数据的一边的数据依次全部填充到 temp
        while (i <= mid) {
            tmp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {
            tmp[t] = arr[j];
            t += 1;
            j += 1;
        }
        //将 temp 数组的元素拷贝到 arr
        //注意，并不是每次都拷贝所有
        t = 0;
        int tmpLeft = left;
        while (tmpLeft <= right) {
            arr[tmpLeft] = tmp[t];
            t += 1;
            tmpLeft += 1;
        }
    }
}
