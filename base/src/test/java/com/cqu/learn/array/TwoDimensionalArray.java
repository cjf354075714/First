package com.cqu.learn.array;

import org.junit.Test;

/**
 * @author Feng
 * @date 2019/10/21
 */
public class TwoDimensionalArray {

    @Test
    public void test() {
        char[][] s = {
                {'a', 'b'},
                {'c', 'd'},
                {'e', 'f'}
        };
        System.err.println(s[2][1]);
    }

    @Test
    public void test1() {
        Object array = new int[]{1, 2};
        System.out.println(array.getClass().isArray());
    }
}
