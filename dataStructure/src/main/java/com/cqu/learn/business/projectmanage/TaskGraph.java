package com.cqu.learn.business.projectmanage;

/**
 * @author Feng
 * @date 2019/9/26
 */
public class TaskGraph {

    private Link[] links;
    private Task[] tasks;
    private boolean[] isVisited;
    private int[][] edges;
    private int length;

    public TaskGraph(Task[] tasks, Link[] links) {
        this.tasks = tasks;
        this.links = links;
        this.length = tasks.length;
        isVisited = new boolean[length];
        edges = new int[length][length];

    }

}
