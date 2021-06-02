package com.heller.datastructures.recursion;

/**
 * 不能处于同一行、 同一列或同一斜线上
 */
public class Queue8 {
    private int max = 8;
    private int[] arr = new int[max];
    private int count = 0;

    private boolean judje(int n) {
        count++;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(i - n) == Math.abs(arr[i] - arr[n])) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public void check(int n) {
        if (n >= max) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.println(count);
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judje(n)) {
                check(n + 1);
            }
        }
    }
}
