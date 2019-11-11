package com.cqu.learn.queueandstack;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 岛屿数量
 * @author Feng
 * @date 2019/10/9
 *
 */
public class IslandCount {

    /**
     * 广度有限遍历，显著的特点就是需要使用一个栈来保存临时遍历的变量
     * 遍历完毕后，会将被遍历完毕后变量的下一个变量入栈
     * 通过判断栈的大小从而遍历完所有变量
     * @param grid 变量数组
     * @return 岛屿数量
     */
    public int numIslands(char[][] grid) {
        Queue<Integer> characterList = new LinkedList<>();
        int num = 0;
        int row = grid.length;
        int column = grid[0].length;
        int [][] visited = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                char temp = grid[i][j];
                if ('1' == temp && visited[i][j] == 0) {
                    visited[i][j] = 1;
                    characterList.add(i);
                    characterList.add(j);
                    while (!characterList.isEmpty()) {
                        int tempRow = characterList.poll();
                        int tempColumn = characterList.poll();
                        if (tempRow - 1 >= 0 && visited[tempRow - 1][tempColumn] == 0
                                && grid[tempRow - 1][tempColumn] == '1') {//向上遍历
                            characterList.add(tempRow - 1);
                            characterList.add(tempColumn);
                            visited[tempRow - 1][tempColumn] = 1;
                        }
                        if (tempRow + 1 < row && visited[tempRow + 1][tempColumn] == 0
                                && grid[tempRow + 1][tempColumn] == '1') {//向下遍历
                            characterList.add(tempRow + 1);
                            characterList.add(tempColumn);
                            visited[tempRow + 1][tempColumn] = 1;
                        }
                        if (tempColumn - 1 >= 0 && visited[tempRow][tempColumn - 1] == 0
                                && grid[tempRow][tempColumn - 1] == '1') {//向左遍历
                            characterList.add(tempRow);
                            characterList.add(tempColumn - 1);
                            visited[tempRow][tempColumn - 1] = 1;
                        }
                        if (tempColumn + 1 < column && visited[tempRow][tempColumn + 1] == 0
                                && grid[tempRow][tempColumn + 1] == '1') {//向右遍历
                            characterList.add(tempRow);
                            characterList.add(tempColumn + 1);
                            visited[tempRow][tempColumn + 1] = 1;
                        }
                    }
                    num ++;
                }
            }
        }
        System.err.println(num);
        return num;
    }

    /**
     *
     * 深度优先遍历，显著的特点就是递归，递归遍历当前变量后
     * 再递归遍历该变量的下一个变量
     * @param grid 二维数组
     * @return 岛屿数量
     */
    public int numIslands2(char[][] grid) {
        int sum = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    sum ++;
                    dfs(i, j, grid);
                }
            }
        }
        return sum;
    }

    private void dfs(int i, int j, char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == '0') {
            return ;
        }
        grid[i][j] = '0';
        dfs(i - 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
        dfs(i + 1, j, grid);
    }
}
