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

    public TaskGraph(Task[] tasks, Link[] links) {
        this.tasks = tasks;
        this.links = links;
        isVisited = new boolean[tasks.length];
        edges = new int[tasks.length][tasks.length];

        for (Link link : this.links) {

        }
    }

}
