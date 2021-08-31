package com.heller.algorithms.search;

import java.util.ArrayList;
import java.util.List;

/**
 * ----二分查找
 * 有序数组
 */
public class BinarySearch {
    public int search(int[] arr, int left, int right, int value) {
        System.out.println("二分查找");
        if (left > right) {
            return -1;
        }
        int midIndex = (left + right) / 2;
        int mid = arr[midIndex];
        if (mid > value) {
            return search(arr, left, midIndex - 1, value);
        } else if (mid < value) {
            return search(arr, midIndex + 1, right, value);
        } else {
            return midIndex;
        }
    }

    //找出全部
    public List<Integer> searchAll(int[] arr, int left, int right, int value) {
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int midIndex = (left + right) / 2;
        int mid = arr[midIndex];
        if (mid > value) {
            return searchAll(arr, left, midIndex - 1, value);
        } else if (mid < value) {
            return searchAll(arr, midIndex + 1, right, value);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(midIndex);
            int tmp = midIndex - 1;
            while (true) {
                if (tmp < 0 || arr[tmp] != value) {
                    break;
                }
                list.add(tmp);
                tmp -= 1;

            }
            tmp = midIndex + 1;
            while (true) {
                if (tmp > arr.length - 1 || arr[tmp] != value) {
                    break;
                }
                list.add(tmp);
                tmp += 1;
            }
            return list;
        }
    }
}
