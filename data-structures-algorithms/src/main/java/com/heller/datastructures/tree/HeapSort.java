package com.heller.datastructures.tree;

/**
 * ----堆排序
 */
public class HeapSort {

    public void sort(int[] arr) {
        //1.构建堆，升序大顶堆，降序小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }
        //2.堆顶元素与末尾元素交换，将最大元素"沉"到数组末端
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            //3.重新调整堆结构
            adjust(arr, 0, i);
        }
    }

    private void adjust(int[] arr, int i, int length) {
        int tmp = arr[i];
        //j:左子节点
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (arr[j] > tmp) {
                arr[i] = arr[j];
                i = j; //继续循环比较
            } else {
                break;
            }
        }
        arr[i] = tmp;
    }
}
