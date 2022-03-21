package com.heller.hw;

/**
 * 岛屿最大面积
 */
public class Area {
    public static void main(String[] args) {

    }

    public int maxArea(int[][] land) {
        int max = 0;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land.length; j++) {
                if (land[i][j] == 1) {
                    max = Math.max(max, dfs(land, i, j));
                }
            }
        }
        return max;
    }
    //深度优先
    public int dfs(int[][] land, int i, int j) {
        if (i < 0 || j < 0 || i >= land.length || j >= land[i].length || land[i][j] == 0) {
            return 0;
        }
        land[i][j] = 0;
        int num = 1;
        num += dfs(land, i + 1, j);
        num += dfs(land, i, j + 1);
        num += dfs(land, i - 1, j);
        num += dfs(land, i, j - 1);
        return num;
    }
}
