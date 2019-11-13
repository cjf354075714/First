package com.cqu.learn.io;

import org.junit.Test;

import java.io.*;

/**
 * @author Feng
 * @date 2019/10/10
 */
public class FileReaderTest {

    @Test
    public void test() {
        File file = new File("D:/cjf/IDEAProject/learn/base/src/main/java/com/cqu/learn/io/file.txt");
        @SuppressWarnings("unused")
		char[] message = new char[1024];
        try {
            Reader fileReader = new FileReader(file);
            int single = fileReader.read();
            System.err.println(single);
            System.err.println((char) single);
//            int i = fileReader.read(message);
//            System.err.println(i);
//            for (int index = 0; index < i && index < message.length; index ++) {
//                System.out.print(message[index]);
//            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
