package com.heller.datastructures.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    @Test
    public void test() {
        String[] vertexs = {"1", "2", "3", "4", "5", "6", "7", "8"};
        Graph graph = new Graph(8);
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0, 1, 1); graph.insertEdge(0, 2, 1); graph.insertEdge(1, 3, 1); graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1); graph.insertEdge(4, 7, 1); graph.insertEdge(2, 5, 1); graph.insertEdge(2, 6, 1); graph.insertEdge(5, 6, 1);

        graph.showGraph();
        //graph.dfs();
        graph.bfs();
    }
}