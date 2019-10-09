package com.cqu.learn.responsibilitychain;

/**
 * @author Feng
 * @date 2019/10/9
 *
 * 这里指定所有实际干活的类的抽象父类
 * 责任链模式是通过某一种标志位来确定责任链对象上的某一个对象
 * 能不能正确完成该请求，完不成，就需要向下转发该请求
 *
 * 每个对象都需要指定责任链上的自己的下一任对象，所以抽象父类也定义好了
 */
public abstract class AbstractLogger {

    public final static int INFO = 1;
    public final static int DEBUG = 2;
    public final static int ERROR = 3;

    protected int level;

    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger logger) {
        this.nextLogger = logger;
    }

    public void logMessage(int level, String message, boolean goOn) {
        if (this.level >= level) {
            write(message);
            //责任链当前对象已经处理好了之后，还需要向下转移嘛
            if (!goOn) {
                return ;
            }
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message, goOn);
        }
    }

    /**
     * 抽象输出方法
     * @param message 输出对象
     */
    abstract protected void write(String message);
}
