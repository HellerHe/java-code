package com.heller.datastructures.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ----图
 */
public class Graph {
    private List<String> vertexList;    //顶点
    private int[][] edges;  //邻结矩阵
    private int numOfEdges; //边
    private boolean[] isVisited;

    public Graph(int n) {
        vertexList = new ArrayList<String>(n);
        edges = new int[n][n];
        numOfEdges = 0;
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdge(int x, int y, int weight) {
        edges[x][y] = weight;
        edges[y][x] = weight;
        numOfEdges++;
    }

    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    private int getFirstNeighbor(int i) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[i][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    private int getNextNeighbor(int i, int first) {
        for (int j = first + 1; j < vertexList.size(); j++) {
            if (edges[i][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    private void dfs(boolean[] isVisited, int i) {
        System.out.println(vertexList.get(i));
        isVisited[i] = true;
        //查找结点 i 的第一个邻接结点 w
        int first = getFirstNeighbor(i);
        while (first != -1) {
            if (!isVisited[first]) {
                dfs(isVisited, first);
            }
            first = getNextNeighbor(i, first);
        }
    }

    //深度优先
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    private void bfs(boolean[] isVisited, int i) {
        int index;
        int first;
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.println(vertexList.get(i));
        isVisited[i] = true;
        queue.addLast(i);

        while (!queue.isEmpty()) {
            index = queue.removeFirst();
            first = getFirstNeighbor(index);
            while (first != -1) {
                if (!isVisited[first]) {
                    System.out.println(vertexList.get(first));
                    isVisited[first] = true;
                    queue.addLast(first);
                }
                first = getNextNeighbor(index, first);
            }
        }
    }
    //广度优先
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }
}
