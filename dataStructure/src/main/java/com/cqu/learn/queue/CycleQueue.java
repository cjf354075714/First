package com.cqu.learn.queue;

/**
 * @author Feng
 * @date 2019/10/8
 *
 * 因为是循环队列，所以当前节点的指针是会一直增加的
 * 头节点的索引也是一直增加的，所以在入队和出队的过程中
 * 需要根据队列的大小取模运算
 */
public class CycleQueue implements Queue {
    private int[] data;
    private int head;
    private int tail;
    private int size;

    public CycleQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return (tail + 1) % size == head;
    }
}
