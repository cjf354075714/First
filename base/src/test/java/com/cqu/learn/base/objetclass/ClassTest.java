package com.cqu.learn.base.objetclass;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Feng
 * @date 2019/11/21
 */
public class ClassTest {

    @Test
    public void test() {
        Class<?> temp = Object.class;
        System.out.println(temp.isAssignableFrom(String.class));
    }

}
