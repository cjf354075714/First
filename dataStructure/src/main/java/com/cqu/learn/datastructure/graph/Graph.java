package com.cqu.learn.datastructure.graph;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Feng
 * @date 2019/09/25
 * 简单的图的实现
 * 需要有三个底层数据结构
 * 节点的数组和二维邻接数组（邻接表）
 * 是否遍历的标志数组
 */
public class Graph {
    private int[][] edges = null;
    private boolean[] isVisited = null;
    private Object[] nodes = null;

    private int size = 0;
    private int currentIndex = 0;

    public Graph(int num) {
        size = num;
        edges = new int[size][size];
        isVisited = new boolean[size];
        nodes = new Object[size];
    }

    public void addNode(Object node) throws Exception {
        nodes[currentIndex] = node;
        currentIndex++;
    }

    public void setNode(int index, Object node) throws Exception {
        if (index >= size) {
            throw new Exception("out of size");
        }
        nodes[index] = node;
    }

    public void addEdge(int row, int column) {
        edges[row][column] = 1;
        edges[column][row] = 1;
    }

    public void deleteEdge(int row, int column) {
        edges[row][column] = 0;
    }

    /**
     * 广度优先遍历
     * 图的底层实际上是一个数组
     * 那么遍历就按照数组的遍历方式来：
     * 从数组的第一个元素开始遍历
     * 第一个遍历完了后，需要设置标志位，表示我已经遍历完了
     * 然后，根据连线查找，连接上的所有的，没有访问过的节点
     * 再一次访问这些节点。然后这些节点也需要进行一次自我的遍历
     * 遍历的就是这些节点的可达节点
     * 那么，怎么实现这个功能呢？
     * 在一个节点访问完毕后，记录下该节点的所有可达节点就行了
     * 使用栈这个数据结构
     * 而且，也会存在一个栈存在相同元素的问题，不过问题不大
     */
    public void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            if (!isVisited[i]) {
                System.err.println(nodes[i]);
                isVisited[i] = true;
                queue.add(i);
                while (queue.size() != 0) {
                    int currentIndex = queue.poll();
                    for (int j = 0; j < size; j++) {
                        if (edges[currentIndex][j] == 1 && !isVisited[j]) {
                            System.err.println(nodes[j]);
                            isVisited[j] = true;
                            queue.add(j);
                        }
                    }
                }
            }
        }
    }

    /**
     * 简单的深度优先遍历，其实深度优先遍历就是循环加上递归
     * 在遇到第一个可以和自己相连接的点后，就直接向下遍历，并不继续后续遍历
     * @param i 从哪个点开始遍历
     */
    private void dfs(int i) {
        if (!isVisited[i]) {
            System.err.println(nodes[i]);
            isVisited[i] = true;
        }
        for (int j = 0; j < size; j++) {
            if (edges[i][j] == 1 && !isVisited[j]) {
                dfs(j);
            }
        }
    }

    public void dfs() {
        dfs(0);
    }
}
