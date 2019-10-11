package com.cqu.learn;

import com.cqu.learn.datatype.DefaultValue;
import com.cqu.learn.nio.StreamIO;
import com.cqu.learn.polymorphism.ObjectToString;
import sun.nio.ch.FileChannelImpl;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

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
