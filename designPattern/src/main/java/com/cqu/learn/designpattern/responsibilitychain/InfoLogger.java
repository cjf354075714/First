package com.cqu.learn.designpattern.responsibilitychain;

/**
 * @author Feng
 * @date 2019/10/9
 */
public class InfoLogger extends AbstractLogger {

    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.err.println("Standard INFO::Logger: " + message);
    }
}
