package com.heller.datastructures.recursion;

/**
 * 迷宫
 */
public class Maze {
    public int[][] map() {
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        return map;
    }

    public void show(int[][] map) {
        System.out.println("小球走过，并标识过的 地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 当 map[i][j] 为 0 表示该点没有走过 当为 1 表示墙 ； 2 表示通路可以走 ； 3 表示该点已经 走过，但是走不通
     * 策略(方法) 下->右->上->左
     */
    public boolean way1(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2; // 假定该点是可以走通
                if (way1(map, i + 1, j)) {
                    return true;
                } else if (way1(map, i, j + 1)) {
                    return true;
                } else if (way1(map, i - 1, j)) {
                    return true;
                } else if (way1(map, i, j - 1)) {
                    return true;
                } else {
                    //说明该点是走不通，是死路  开始回溯
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    /**
     * 右下上左
     */
    public boolean way2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (way2(map, i, j + 1)) {
                    return true;
                } else if (way2(map, i + 1, j)) {
                    return true;
                } else if (way2(map, i - 1, j)) {
                    return true;
                } else if (way2(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
