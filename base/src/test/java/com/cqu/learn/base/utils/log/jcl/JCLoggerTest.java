package com.cqu.learn.base.utils.log.jcl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * @author Feng
 * @date 2019/10/28
 */
public class JCLoggerTest {

    @Test
    public void test() {
        Log log = LogFactory.getLog(JCLoggerTest.class);
        log.debug("debug");
        log.error("error");
    }
}
