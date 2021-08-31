package com.heller.algorithms.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class InsertSortTest {

    @Test
    public void sort() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
        InsertSort insertSort = new InsertSort();
        insertSort.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(insertSort.count);
    }
}