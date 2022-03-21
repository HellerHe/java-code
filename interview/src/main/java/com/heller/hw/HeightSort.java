package com.heller.hw;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 根据身高重建队列
 * [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]] => [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * 1.先按k从大到小排序，v从小到大排序
 * 2.按v插入到相应位置
 * [7,0], [7,1], [6,1], [5,0], [5,2], [4,4] => [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
 */
public class HeightSort {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] sort = sort(people);
        for (int[] i : sort) {
            System.out.println(Arrays.toString(i));
        }
    }

    private static int[][] sort(int[][] people) {
        Arrays.sort(people, (arr1, arr2) -> arr1[0] != arr2[0] ? arr2[0] - arr1[0] : arr1[1] - arr2[1]);
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[people.length][2]);
    }
}
