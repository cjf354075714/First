package com.cqu.learn.base.classaccess;

/**
 * @author Feng
 * @date 2019/11/05
 */
public class AnonymousInnerClass {

    public void fun() {
        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("这就是匿名内部类");
                    }
                }
        );
        thread.start();
    }
}
