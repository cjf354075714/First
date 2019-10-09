package com.cqu.learn.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Feng
 * @date 2019/10/9
 *
 *
 */
public class IslandCount {

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
}
