package com.cqu.learn.io;

import org.junit.Test;

import java.io.*;

/**
 * @author Feng
 * @date 2019/10/11
 */
public class SystemIOTest {

    @Test
    public void test() {
        fun1();
    }

    /**
     * System.in 和 System.out 是 InputStream 和 OutputStream的实例
     * 我们输入的是字符需要使用包装流来包装一下
     *
     * 这里的预期之外的问题是输入流阻塞线程等待输出，然后输出流也被阻塞了
     */
    @SuppressWarnings("unused")
	private static void fun() {
        try {
            Reader inputStreamReader = new InputStreamReader(System.in);
            Reader reader = new BufferedReader(inputStreamReader);
            Writer outputStreamWriter = new OutputStreamWriter(System.out);
            Writer writer = new BufferedWriter(outputStreamWriter);
//            writer.write("请输入你的输入");
            System.err.print("请输入");
            int simple = reader.read();
            System.err.println((char) simple);
            reader.close();
            inputStreamReader.close();
            writer.close();
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fun1() {
        Reader inputStreamReader = new InputStreamReader(System.in);
        Reader reader = new BufferedReader(inputStreamReader);
        System.err.print("输入字符，按q结束");
        try {
            char message;
            do {
                message = (char) reader.read();
                System.out.println(message);
            } while (message != 'q');
            inputStreamReader.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fun2() {
        Reader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String message;
        try {
            do {
                message = reader.readLine();
                System.err.println(message);
            } while (!"q".equals(message));
            inputStreamReader.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
