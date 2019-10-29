package com.cqu.learn.utils.log.log4j;

import com.cqu.learn.utils.log.log4j2.Log4j2Test;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Feng
 * @date 2019/10/28
 */
public class Log4JTest {

    @Test
    public void test() {
        Logger logger = LoggerFactory.getLogger(Log4j2Test.class);
        logger.warn("trace");
    }
}
