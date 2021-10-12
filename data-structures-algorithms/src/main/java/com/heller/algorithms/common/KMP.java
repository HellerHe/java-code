package com.heller.algorithms.common;

import java.util.Arrays;

/**
 * ----kmp算法
 * 字符串匹配查找
 */
public class KMP {
    //暴力匹配
    public int violenceMatch(String str1, String str2) {
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int i = 0;
        int j = 0;
        while (i < c1.length && j < c2.length) {
            if (c1[i] == c2[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == c2.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    public int kmpSearch(String str1, String str2) {
        int[] next = kmpNext(str1);
        for (int i = 0, j = 0; i < str2.length(); i++) {
            //核心
            while (j > 0 && str2.charAt(i) != str1.charAt(j)) {
                j = next[j - 1];
            }
            if (str2.charAt(i) == str1.charAt(j)) {
                j++;
            }
            if (j == str1.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    //部分匹配表
    private int[] kmpNext(String str1) {
        int[] next = new int[str1.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < str1.length(); i++) {
            //核心
            while (j > 0 && str1.charAt(i) != str1.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str1.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        int[] next = kmp.kmpNext("ABCDABD");
        System.out.println(Arrays.toString(next));
        int i = kmp.kmpSearch("ABCDABD", "BBC ABCDAB ABCDABCDABDE");
        System.out.println(i);
    }
}
