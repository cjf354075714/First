package com.cqu.learn.algorithm.queueandstack;

import org.junit.Test;

public class RpnExpressionTest {

    @Test
    public void test() {
        String[] strings = new String[]{"4","13","5","/","+"};
        System.out.println(RpnExpression.solution(strings));
    }
}
