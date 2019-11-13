package com.cqu.learn.business.projectmanage;


import java.util.Calendar;

/**
 * @author Feng
 * @date 2019/9/26
 */
public class Task {
    private int id;
    private int duration;
    private Calendar startDate;
    private Calendar endDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Calendar getStartDate() {
		return startDate;
	}
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}
	public Calendar getEndDate() {
		return endDate;
	}
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}
}
