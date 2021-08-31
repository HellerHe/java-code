package com.heller.algorithms.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class ShellSortTest {

    @Test
    public void changeSort() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
        ShellSort shellSort = new ShellSort();
        //shellSort.changeSort(arr);
        shellSort.moveSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}