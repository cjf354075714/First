package com.cqu.learn.threadpool.threadfactory;

import java.util.concurrent.ThreadFactory;

/**
 * @author Feng
 * @date 2019/10/18
 */
public class DefaultThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        return new Thread();
    }
}
