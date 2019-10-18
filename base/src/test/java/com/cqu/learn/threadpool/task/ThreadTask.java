package com.cqu.learn.threadpool.task;

/**
 * @author Feng
 * @date 2019/10/18
 */
public class ThreadTask implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
