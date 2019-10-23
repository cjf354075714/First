package com.cqu.learn.dynamicprogress;

import org.junit.Test;

/**
 * @author Feng
 * @date 2019/10/23
 */
public class DynamicProgressTest {

    @Test
    public void test() {
        CompleteSquare completeSquare = new CompleteSquare();
        System.err.println(completeSquare.numSquares(13));
    }
}
