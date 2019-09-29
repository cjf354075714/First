package com.cqu.learn.queue;

import java.util.List;

/**
 * @author Feng
 * @date 2019/9/29
 *
 * 队列的简单实现
 * 队列底层是一个数组还是一个链表？
 * 数组的话，遍历和索引位寻找方便，但是大小固定
 * 链表大小不固定，但是索引难以维护
 */
public class Queue {

    private Object[] data;
    private int head = -1;
    private int tail = head;
    private int size = 0;

    public Queue(int size) {
        data = new Object[size];
        this.size = size;
    }
    public void add(Object item) throws Exception{
        if (tail >= size) {
            throw new Exception("队列已满");
        }
        tail++;
        data[tail] = item;
    }
    public Object pop() throws Exception {
        return null;
    }
}
