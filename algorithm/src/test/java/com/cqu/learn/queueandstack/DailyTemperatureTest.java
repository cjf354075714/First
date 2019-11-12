package com.cqu.learn.queueandstack;

import com.cqu.learn.queueandstack.DailyTemperature;
import org.junit.Test;

/**
 * @author Feng
 * @date 2019/10/24
 */
public class DailyTemperatureTest {

    @Test
    public void test() {
        DailyTemperature dailyTemperature = new DailyTemperature();
        int[] result = dailyTemperature.dailyTemperatures3(new int[]{55,38,53,81,61,93,97,32,43,78});
        for (int s : result) {
            System.err.print(s + " ");
        }
    }
}
