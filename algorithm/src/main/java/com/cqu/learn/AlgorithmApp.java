package com.cqu.learn;

import com.cqu.learn.bfs.IslandCount;

/**
 * Hello world!
 *
 */
public class AlgorithmApp
{
    public static void main( String[] args ) {
        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        IslandCount islandCount = new IslandCount();
        System.err.print(islandCount.numIslands2(grid));
    }
}
