package com.cqu.learn.utils.log.jul;

import org.junit.Test;

import java.io.IOException;
import java.util.logging.*;

/**
 * @author Feng
 * @date 2019/10/28
 *
 * 这是 jul 的简单实现，可以看到，jul 实现了全代码的配置实现，包括自定义日志等级
 * 自定义日志输出格式，通过继承  Formatter 类实现
 * 还有多个写入文件，输入到 Socket 等
 * 但是 jul 使用的是 err 来输出日志，性能还是不够好
 * 而且，没有实现隔一天等自动转换日志输出文件的功能，应该是我们自定义 handler 来实现，通过继承 Handler 接口实现
 */
public class JULoggerTest {

    @Test
    public void test() throws IOException {
        // 获取打印日志的对象
        Logger logger = Logger.getLogger("JULoggerTest");
        // 创建简单格式对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        // 创建 XML 格式配置对象
        @SuppressWarnings("unused")
		XMLFormatter xmlFormatter = new XMLFormatter();
        // 指定文件输入的目录
        FileHandler fileHandler = new FileHandler("jul.log");
        // 指定该日志输入到文件的等级
        fileHandler.setLevel(Level.ALL);
        // 设置日志文件输入的格式
        fileHandler.setFormatter(simpleFormatter);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        logger.addHandler(consoleHandler);
        logger.addHandler(fileHandler);
        logger.log(Level.INFO, "输出{0}", "你好");
    }
}
