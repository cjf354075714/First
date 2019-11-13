package com.cqu.learn.utils.log.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Feng
 * @date 2019/10/29
 */
public class Log4j2Test {

    private final static Logger LOGGER = LoggerFactory.getLogger(Log4j2Test.class);

    public static void main(String[] args) {
        LOGGER.trace("trace");
        LOGGER.debug("debug");
        LOGGER.info("info");
        LOGGER.warn("warn");
        LOGGER.error("error");
    }
}
