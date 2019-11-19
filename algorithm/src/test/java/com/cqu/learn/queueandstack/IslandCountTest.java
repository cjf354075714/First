package com.cqu.learn.queueandstack;

import org.junit.Test;

public class IslandCountTest {

    @Test
    public void test() {
        char[][] gird = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','1'}
        };
        System.out.println(IslandCount.numIslands2(gird));
    }
}
