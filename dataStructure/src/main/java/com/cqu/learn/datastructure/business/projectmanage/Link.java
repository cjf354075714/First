package com.cqu.learn.datastructure.business.projectmanage;

/**
 * @author Feng
 * @date 2019/9/26
 *
 * 连接两个任务的连接点
 */
public class Link {
    private int id;
    private int source;
    private int target;
    private RelationType type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public RelationType getType() {
		return type;
	}
	public void setType(RelationType type) {
		this.type = type;
	}
}
