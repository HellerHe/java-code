package com.heller.hw;

/**
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度为 O(n)
 */
public class ArrayMaxSum {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(maxSum(arr));
    }

    private static int maxSum(int[] array) {
        int sum = array[0];
        int maxSum = array[0];
        for (int i = 0; i < array.length; i++) {
            sum = Math.max(sum + array[i], array[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
