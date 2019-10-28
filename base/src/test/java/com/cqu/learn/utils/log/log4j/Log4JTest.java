package com.cqu.learn.utils.log.log4j;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author Feng
 * @date 2019/10/28
 */
public class Log4JTest {

    @Test
    public void test() {
        Logger logger = Logger.getLogger(Log4JTest.class);
        logger.warn("trace");
    }
}
