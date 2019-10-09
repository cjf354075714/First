package com.cqu.learn.responsibilitychain;

/**
 * @author Feng
 * @date 2019/10/9
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.err.println("Standard ERROR::Logger: " + message);
    }
}
