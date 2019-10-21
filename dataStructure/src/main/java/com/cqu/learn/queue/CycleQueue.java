package com.cqu.learn.queue;

/**
 * @author Feng
 * @date 2019/10/8
 *
 * 因为是循环队列，所以当前节点的指针是会一直增加的
 * 头节点的索引也是一直增加的，所以在入队和出队的过程中
 * 需要根据队列的大小取模运算
 */
public class CycleQueue <T> implements Queue<T> {

    /**
     * 队列数据载体
     */
    private Object[] data;

    /**
     * 队列数据数量
     */
    private int size = 0;

    /**
     * 队列数据当前索引
     */
    private int tail = -1;

    /**
     * 队列数据头部索引
     */
    private int head = -1;

    public CycleQueue(int size) {
        this.size = size;
        this.data = new Object[size];
    }

    public boolean isEmpty() {
        return this.head == this.tail && this.head == -1;
    }

    public boolean isFull() {
        return this.tail % this.size + 1 == this.head;
    }

    public void enQueue(Object data) throws Exception {
        if (isFull()) {
            throw new Exception("循环队列已满");
        }
        if (isEmpty()) {
            this.head++;
        }
        this.tail = (this.tail + 1) % this.size;
        this.data[this.tail] = data;

    }

    @SuppressWarnings("unchecked")
    public T deQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("循环队列为空");
        }
        T temp = null;
        if (this.head == this.tail) {
            temp = (T) this.data[this.head];
            System.arraycopy(data, 0, data, 0, size);
            data[this.head] = null;
            this.head = -1;
            this.tail = -1;
            return temp;
        }
        temp = (T) this.data[this.head];
        System.arraycopy(data, 0, data, 0, size);
        data[this.head] = null;
        this.head = this.head % this.size + 1;
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object o : this.data) {
            if (null == o) {
                stringBuilder.append("*").append(" ");
            }else {
                stringBuilder.append(o.toString()).append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
