package com.heller.datastructures.recursion;

import org.junit.jupiter.api.Test;

public class MazeTest {
    @Test
    public void test() {
        Maze maze = new Maze();
        int[][] map1 = maze.map();
        maze.way1(map1, 1, 1);
        maze.show(map1);
        System.out.println();
        int[][] map2 = maze.map();
        maze.way2(map2, 1, 1);
        maze.show(map2);
    }
}