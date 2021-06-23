package com.heller.algorithms.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void sort() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(10);
        }
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}