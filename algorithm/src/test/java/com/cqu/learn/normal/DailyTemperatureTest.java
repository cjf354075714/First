package com.cqu.learn.normal;

import org.junit.Test;

/**
 * @author Feng
 * @date 2019/10/24
 */
public class DailyTemperatureTest {

    @Test
    public void test() {
    DailyTemperature dailyTemperature = new DailyTemperature();
        int[] s = dailyTemperature.dailyTemperatures2(null);
        for (int a : s) {
            System.err.println(a);
        }
    }
}
