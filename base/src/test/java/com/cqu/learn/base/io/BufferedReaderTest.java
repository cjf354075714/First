package com.cqu.learn.base.io;

import org.junit.Test;

import java.io.*;

/**
 * @author Feng
 * @date 2019/10/10
 */
public class BufferedReaderTest {

    @Test
    public void test() {
        File file = new File("D:/cjf/IDEAProject/learn/base/src/main/java/com/cqu/learn/io/file.txt");
        try {
            FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
