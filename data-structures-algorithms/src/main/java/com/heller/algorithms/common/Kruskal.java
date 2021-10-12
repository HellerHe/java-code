package com.heller.algorithms.common;

/**
 * ----克鲁斯卡尔算法
 * 按照权值从小到大的顺序选择 n-1 条边，并保证这 n-1 条边不构成回路
 */
public class Kruskal {
    int INF = Integer.MAX_VALUE;
    char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    int matrix[][] = {
            { 0, 12, INF, INF, INF, 16, 14},
            { 12, 0, 10, INF, INF, 7, INF},
            { INF, 10, 0, 3, 5, 6, INF},
            { INF, INF, 3, 0, 4, INF, INF},
            { INF, INF, 5, 4, 0, 2, 8},
            { 16, 7, 6, INF, 2, 0, 9},
            { 14, INF, INF, INF, 8, 9, 0}};

}
