package com.cqu.learn.io.exercise;

import org.junit.Test;

import java.io.*;

/**
 * @author Feng
 * @date 2019/10/21
 */
public class FileTest {

    @Test
    public void test() throws Exception {
        File file = new File("D:\\cjf\\IDEAProject\\learn\\base\\src\\main\\java\\com\\cqu\\learn\\io\\file.txt");
        OutputStream os = new FileOutputStream(file);
        BufferedOutputStream bufferedOs = new BufferedOutputStream(os);
        char s = 0b0100_1000;
        bufferedOs.write(s);
//        bufferedOs.flush();
        bufferedOs.close();
    }
}
