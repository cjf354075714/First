package com.cqu.learn.algorithm.queueandstack;

import java.util.Stack;

/**
 * @author Feng
 * @date 2019/10/24
 *
 *
 * 题目：给定一个数组，输出每个数字距离自己右边的大于自己的数的最短距离
 * 如：[20, 33, 0, 9, 200, 5]
 * 输出：[1，3，1，1，0，0]
 */
public class DailyTemperature {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        int s = 1;
        Stack<Integer> temp = new Stack<>();
        for (int i = 1; i < T.length; i++) {
            int j = 0;
            while (j < i) {
                temp.push(T[j]);
                j ++;
            }
            for (int k = i; k < T.length; k++) {
                if (temp.peek() < T[k]) {
                    result[i- 1] = s;
                    break;
                } else {
                    s++;
                }
            }
            s = 1;
            temp.clear();
        }
        return result;
    }

    public int[] dailyTemperatures2(int[] T) {
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[i] < T[j]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    public int[] dailyTemperatures3(int[] T) {
        int[] result = new int[T.length];
        for (int i = result.length - 2; i >= 0; i--) {
            int j = i;
            int k = j +1;
            while (j <= result.length - 1 && k <= result.length -1) {
                if (T[j] < T[k]) {
                    result[j] = k - j;
                    break;
                } else {
                    if (result[j] == 0) {
                        k ++;
                    } else {
                        k += result[j];
                    }
                }
            }
        }
        return result;
    }
}
