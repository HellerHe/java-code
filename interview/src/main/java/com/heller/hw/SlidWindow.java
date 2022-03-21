package com.heller.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值
 *
 */
public class SlidWindow {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1}; // [4,4,6,6,6,5]
        System.out.println(calc(arr, 3));
    }

    private static List<Integer> calc(int[] arr, int step) {
       List<Integer> result = new ArrayList<>();
        //大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < step; i++) {
            queue.offer(arr[i]);
        }
        for (int i = step; i < arr.length; i++) {
            result.add(queue.peek());
            queue.remove(arr[i - step]);
            queue.add(arr[i]);
        }
        result.add(queue.peek());
        return result;
    }
}
