package com.heller.algorithms.search;

import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class SearchTest {
    @Test
    public void test() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
        SeqSearch seqSearch = new SeqSearch();
        int index = seqSearch.search(arr, 5);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println(index);
        }
    }

    @Test
    public void binary() {
        int[] arr = {1, 8, 10, 89,1000,1000, 1234};
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.search(arr, 0, arr.length - 1, 1);
        List<Integer> list = binarySearch.searchAll(arr, 0, arr.length - 1, 1000);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println(index);
        }
        System.out.println(list);
    }

    @Test
    public void insert() {
        int[] arr = {1, 8, 10, 89,1000,1000, 1234};
        InsertValueSearch insertValueSearch = new InsertValueSearch();
        int index = insertValueSearch.search(arr, 0, arr.length - 1, 1);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println(index);
        }
    }

    @Test
    public void fib() {
        int[] arr = {1, 8, 10, 89,1000,1000, 1234};
        int index = FibonacciSearch.fibSearch(arr, 89);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println(index);
        }
    }
}