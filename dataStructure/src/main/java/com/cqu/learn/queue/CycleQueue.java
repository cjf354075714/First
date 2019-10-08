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

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head ++;
        }
        tail = (tail ++) %size;
        data[tail] = value;
        return true;
    }

    public boolean deQueue() throws Exception{
        if (isEmpty()) {
            return false;
        }
        data[head] = 0;
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = (head + 1) % size;
        }
        return true;
    }
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[tail];
    }
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }
}
