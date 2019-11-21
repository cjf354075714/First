package com.cqu.learn.base.object;

import org.junit.Test;

/**
 * @author Feng
 * @date 2019/11/20
 */
public class EqualsTest {

    @Test
    public void test() {
        int i = 0;
        int j = 0;
        System.out.println(i == j);

        Integer m = new Integer(0);
        Integer n = new Integer(0);
        System.out.println(m == n);
    }

    @Test
    public void test2() {
        String a = "a";
        String a1 = new String("a");
        System.out.println(a==a1);
    }
}
