package com.cqu.learn.utils.url;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Feng
 * @date 2019/10/28
 */
public class URLTest {

    @Test
    public void test() throws IOException {
        URL url = new URL("https://www.baidu.com");
        System.out.println(url.getFile());
        System.out.println(url.getProtocol());
        URLConnection urlConnection = url.openConnection();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
        byte[] message = new byte[1024];
        StringBuilder stringBuffer = new StringBuilder();
        while (bufferedInputStream.read(message) != -1) {
            stringBuffer.append(new String(message));
        }
        System.out.println(stringBuffer.toString());
    }

    @Test
    public void test1() {

    }
}
