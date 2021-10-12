package com.heller.algorithms.common;

/**
 * ----动态规划
 */
public class Dynamic {
    public void knapsackProblem() {
        int[] weight = {1, 4, 3};
        int[] val = {1500, 3000, 2000};
        int max = 4;

        int[][] table = new int[val.length + 1][max + 1];
        int[][] path = new int[val.length + 1][max + 1];
        for (int i = 0; i < table[0].length; i++) {
            table[0][i] = 0;
        }
        for (int i = 0; i < table.length; i++) {
            table[i][0] = 0;
        }

        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[0].length; j++) {
                if (weight[i - 1] > j) {
                    table[i][j] = table[i - 1][j];
                } else {
                    if (table[i - 1][j] < val[i - 1] + table[i - 1][j - weight[i - 1]]) {
                        table[i][j] = val[i - 1] + table[i - 1][j - weight[i - 1]];
                        path[i][j] = 1;
                    } else {
                        table[i][j] = table[i - 1][j];
                    }
                }
            }
        }

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d 个商品放入到背包\n", i);
                j -= weight[i - 1];
            }
            i--;
        }
    }

    public static void main(String[] args) {
        Dynamic dynamic = new Dynamic();
        dynamic.knapsackProblem();
    }
}
