package com.cqu.learn.threadpool;

import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author Feng
 * @date 2019/10/18
 */
public class ThreadPoolTest {

    @Test
    public void test() {
        BlockingQueue<Runnable> workQueue = new SynchronousQueue<>();

    }
}
