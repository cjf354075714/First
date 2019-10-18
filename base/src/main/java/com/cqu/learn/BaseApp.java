package com.cqu.learn;

import java.io.*;

/**
 * Hello world!
 *
 */
public class BaseApp
{
    public static void main( String[] args ) throws Exception {
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
