package com.cqu.learn;

import com.cqu.learn.responsibilitychain.AbstractLogger;
import com.cqu.learn.responsibilitychain.DebugLogger;
import com.cqu.learn.responsibilitychain.ErrorLogger;
import com.cqu.learn.responsibilitychain.InfoLogger;

/**
 * Hello world!
 *
 * @author Feng
 */
public class DesignPatternApp
{
    public static void main( String[] args ) {
        /*
        接下来是责任链的测试
        chain of responsibility pattern
         */
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);
        AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);
        infoLogger.logMessage(AbstractLogger.INFO, "info信息会被 errorLogger 打印出来", true);
    }
}
