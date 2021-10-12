package com.heller.algorithms.common;

/**
 * ----普利姆算法
 * 找出只有(n-1)条边包含所有 n 个顶点的连通子图
 */
public class Prim {
    char[] data = new char[]{'A','B','C','D','E','F','G'};
    int[][] weight = new int[][]{
            {10000, 5, 7, 10000, 10000, 10000, 2},
            {5, 10000, 10000, 9, 10000, 10000, 3},
            {7, 10000, 10000, 10000, 8, 10000, 10000},
            {10000, 9, 10000, 10000, 10000, 4, 10000},
            {10000, 10000, 8, 10000, 10000, 5, 4},
            {10000, 10000, 10000, 4, 5, 10000, 6},
            {2, 3, 10000, 10000, 4, 6, 10000}};

    public void run(int v) {
        int visited[] = new int[data.length];
        //节点标记已访问
        visited[v] = 1;
        int minWeight = 10000;
        int x = -1, y = -1;
        for (int i = 1; i < data.length; i++) { //找出data.length-1条边
            for (int j = 0; j < data.length; j++) { //代表已访问
                for (int k = 0; k < data.length; k++) { //代表未访问
                    if (visited[j] == 1 && visited[k] == 0 && weight[j][k] < minWeight) {
                        minWeight = weight[j][k];
                        x = j;
                        y = k;
                    }
                }
            }
            System.out.println("边<" + data[x] + "," + data[y] + "> 权值:" + minWeight);
            visited[y] = 1;
            minWeight = 10000;
        }
    }

    public static void main(String[] args) {
        Prim prim = new Prim();
        prim.run(1);
    }
}
