package com.cqu.learn;

import com.cqu.learn.graph.Graph;

/**
 * Hello world!
 *
 */
public class DataStructureApp
{
    public static void main( String[] args ) throws Exception {
        Graph graph = new Graph(6);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);

        graph.addEdge(0,1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 3);
        graph.dfs();
    }
}
