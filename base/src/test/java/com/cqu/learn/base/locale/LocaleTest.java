package com.cqu.learn.base.locale;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Feng
 * @date 2019/11/06
 */
public class LocaleTest {

    @Test
    public void test() {
        // 获取默认 Locale 对象
        Locale locale = Locale.getDefault();
        // 获取国家代码
        System.out.println(locale.getCountry());
    }

    @Test
    public void testResourceBundle() {
        // 创建一个 ResourceBundle 对象，这个对象代表着获取国家化的 properties 文件
        // 比如获取 LocaleStrings_zh_CN.properties，获取之后，就可以直接读取里面的值了
        ResourceBundle resourceBundle = ResourceBundle.getBundle("", Locale.getDefault());
        String value = resourceBundle.getString("");
        System.out.println(value);
    }
}
