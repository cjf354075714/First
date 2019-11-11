package com.cqu.learn.utils.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Feng
 * @date 2019/11/10
 */
public class RegexTest {

    @Test
    public void test() {
        String str = "1a3-\\";
        String regex = "([0-9]){3}-\\\\";
        System.err.println(Pattern.matches(regex, str));
    }

    @Test
    public void test1() {
        String str = "hello";
        String regex = "[a-z]{3,5}";
        System.err.println(Pattern.matches(regex, str));
    }

    /**
     * 匹配某个字符串是否包含数字
     * 规则就是：前面可以出现任何字符 .
     * 接着就是该字符的次数就是任意次 *
     * 再下来就是匹配数字 \d
     * 最后又是任意字符，任意个数 .*
     */
    @Test
    public void test2() {
        String str = "ab0";
        String regex = ".*\\d.*";
        System.err.println(Pattern.matches(regex, str));
    }

    @Test
    public void test3() {
        String str = "13452591929";
        // 这里的[0-35-9]，可以这样写，目的就是除了 4 这个数字
        // 直接定义的是一个匹配规则
        String regex = "1[2378][0-57-9]{9}";
        System.err.println(Pattern.matches(regex, str));
    }

    @Test
    public void test4() {
        String str = "13452591929";
        String regex = "1[2378][0-57-9]{9}";
        // 根据指定的匹配规则，预先编译一下规则，生成一个 pattern 对象
        Pattern p = Pattern.compile(regex);
        // 创建一个匹配器，就是说一般的正则表达式的使用顺序就是
        // 先写好 regex 匹配规则，然后生成 pattern 对象
        // 再根据 pattern 对象生成 matcher 对象，就是匹配器
        // 匹配器对象将会生成合适的结果
        Matcher m = p.matcher(str);
        System.err.println(m.matches());
    }

    @Test
    public void test5() {
        String str = "12a6B985Ccv65";
        String regex = "[a-zA-Z]+";
        String regex2 = "\\d+";
        System.err.println(str.replaceAll(regex, "&"));
        System.err.println(str.replaceAll(regex2, "0"));
    }

    @Test
    public void test6() {
        String str = "oneAtowAthreeDfourJfive";
        String regex = "[A-Z]";
        String[] arr = str.split(regex);
        for (String s : arr) {
            System.err.print(s + "+");
        }
    }

    /**
     * 匹配年月日
     */
    @Test
    public void test7() {
        String regex = "(\\d{4})-(\\d{2})-(\\d{2})";
        Pattern pattern = Pattern.compile(regex);
        String date = "2019-11-10";
        Matcher matcher = pattern.matcher(date);
        System.err.println(matcher.matches());
    }

    @Test
    public void test8() {
        String str = "0";
        String regex = "[^0]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        System.err.println(matcher.matches());
    }
}
