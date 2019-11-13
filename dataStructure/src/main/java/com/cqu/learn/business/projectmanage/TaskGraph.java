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

	public Link[] getLinks() {
		return links;
	}

	public void setLinks(Link[] links) {
		this.links = links;
	}

	public Task[] getTasks() {
		return tasks;
	}

	public void setTasks(Task[] tasks) {
		this.tasks = tasks;
	}

	public boolean[] getIsVisited() {
		return isVisited;
	}

	public void setIsVisited(boolean[] isVisited) {
		this.isVisited = isVisited;
	}

	public int[][] getEdges() {
		return edges;
	}

	public void setEdges(int[][] edges) {
		this.edges = edges;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
