package com.heller.algorithms.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void sort() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
        BubbleSort bubbleSort = new BubbleSort();
        //bubbleSort.sort(arr);

        MergeSort mergeSort = new MergeSort();
        //mergeSort.sort(arr, 0, arr.length-1, new int[100]);

        RadixSort radixSort = new RadixSort();
        radixSort.sort(arr);

        System.out.println(Arrays.toString(arr));
        System.out.println(bubbleSort.count);
    }

    @Test
    public void test() {
        Random random = new Random();
        System.out.println(random.nextInt(100));

        int[] arr =new int[]{1, 2, 3, 4};
        for (int i = 2; i >=0; i--) {
            arr[i + 1] = arr[i];

        }
        System.out.println(Arrays.toString(arr));
    }
}