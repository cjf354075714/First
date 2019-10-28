package com.cqu.learn.utils.log.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * @author Feng
 * @date 2019/10/28
 */
public class Log4j2Test {

    @Test
    public void test() {
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.trace("输出{}", "a");
    }
}
