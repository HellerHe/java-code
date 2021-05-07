package com.heller.datastructures.sparsearray;

/**
 * ----稀疏数组
 *
 */
public class SparseArray {
    /**
     * 二维数组 转 稀疏数组的思路
     * 1. 遍历  原始的二维数组，得到有效数据的个数 sum
     * 2. 根据sum 就可以创建 稀疏数组 sparseArr   int[sum + 1] [3]
     * 3. 将二维数组的有效数据数据存入到 稀疏数组
     *
     * 稀疏数组转原始的二维数组的思路
     * 1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
     * 2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
     */
    public static void main(String[] args) {
        int[][] chess = new int[11][11];
        chess[1][2] = 1;
        chess[2][3] = 2;
        chess[4][5] = 2;
        System.out.println("原始的二维数组~~");
        for (int[] row : chess) {
            for (int data : row) {
                System.out.print("\t" + data);
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chess[i][j] != 0) {
                    sum++;
                }
            }
        }
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chess[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chess[i][j];
                }
            }
        }
        System.out.println("得到稀疏数组为~~~~");
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.print("\t" + data);
            }
            System.out.println();
        }

        //将稀疏数组 --》 恢复成 原始的二维数组
        int[][] chessN = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessN[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("恢复后的二维数组");
        for (int[] row : chessN) {
            for (int data : row) {
                System.out.print("\t" + data);
            }
            System.out.println();
        }
    }
}
