package com.cqu.learn.normal;

import javax.xml.transform.Result;
import java.util.Stack;

/**
 * @author Feng
 * @date 2019/10/24
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
        return null;
    }
}
