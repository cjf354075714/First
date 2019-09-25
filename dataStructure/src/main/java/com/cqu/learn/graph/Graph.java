package com.cqu.learn.graph;

import com.sun.javafx.geom.Edge;

/**
 * @author Feng
 * @date 2019/09/25
 * 简单的图的实现
 * 需要有三个底层数据结构
 * 节点的数组和二维邻接数组（邻接表）
 * 是否遍历的标志数组
 */
public class Graph {
    private Integer[][] edges = null;
    private Boolean[] isVisited = null;
    private String[] nodes = null;

    public Graph(Integer num) {
        edges = new Integer[num][num];
        isVisited = new Boolean[num];
        nodes = new String[num];
    }

}
