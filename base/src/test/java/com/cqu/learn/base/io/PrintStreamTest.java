package com.cqu.learn.base.io;

import org.junit.Test;

import java.io.*;

/**
 * @author Feng
 * @date 2019/10/14
 */
public class PrintStreamTest {

    @Test
    public void text() throws FileNotFoundException {
        File file = new File("D:/cjf/IDEAProject/learn/base/src/main/java/com/cqu/learn/io/file.txt");
        PrintStream printStream = new PrintStream(new FileOutputStream(file));
        printStream.println(123);
        printStream.close();
    }
}
