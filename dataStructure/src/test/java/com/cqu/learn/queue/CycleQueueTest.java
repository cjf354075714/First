package com.cqu.learn.queue;

import org.junit.Test;

/**
 * @author Feng
 * @date 2019/10/21
 */
public class CycleQueueTest {

    @Test
    public void test() throws Exception {
        CycleQueue cycleQueue = new CycleQueue(5);
        cycleQueue.enQueue(1);
        System.err.println(cycleQueue.toString());
        cycleQueue.deQueue();
        System.err.println(cycleQueue.toString());
        cycleQueue.enQueue(2);
        System.err.println(cycleQueue.toString());
        cycleQueue.enQueue(3);
        cycleQueue.enQueue(4);
        cycleQueue.deQueue();
        System.err.println(cycleQueue.toString());
        cycleQueue.enQueue(5);
        cycleQueue.enQueue(6);
        System.err.println(cycleQueue.toString());
        cycleQueue.enQueue(7);
        System.err.println(cycleQueue.toString());
        System.err.println(cycleQueue.deQueue());
        cycleQueue.enQueue(8);
        System.err.println(cycleQueue);
    }
}
