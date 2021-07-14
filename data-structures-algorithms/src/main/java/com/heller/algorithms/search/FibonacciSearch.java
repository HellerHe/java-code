package com.heller.algorithms.search;

import javax.swing.*;
import java.util.Arrays;

/**
 * ----斐波那契查找
 */
public class FibonacciSearch {
    public static int max = 20;

    public static int[] fib() {
        int[] f = new int[20];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < max; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static int fibSearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;
        int mid = 0;
        while (high > fib()[k] - 1) {
            k++;
        }

        int[] tmp = Arrays.copyOf(arr, fib()[k]);
        for (int i = high+1; i <tmp.length; i++) {
            tmp[i] = arr[high];
        }
        while (low <= high) {
            mid = low + fib()[k - 1] - 1;
            if (value < tmp[mid]) {
                high = mid - 1;
                k--;
            } else if (value > tmp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
