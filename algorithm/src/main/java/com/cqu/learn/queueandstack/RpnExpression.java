package com.cqu.learn.queueandstack;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RpnExpression {

    public static int solution(String[] tokens) {
        Pattern number = Pattern.compile("(\\d+)|(-\\d+)");
        Pattern symbol = Pattern.compile("[+-/*]");
        Stack<String> temp = new Stack<>();
        for (String s : tokens) {
            Matcher matcher = number.matcher(s);
            if (matcher.matches()) {
                temp.push(s);
            } else {
                int second = Integer.parseInt(temp.pop());
                int first = Integer.parseInt(temp.pop());
                switch (s) {
                    case "+":
                        temp.push(String.valueOf(first + second));
                        break;
                    case "-":
                        temp.push(String.valueOf(first - second));
                        break;
                    case "*":
                        temp.push(String.valueOf(first * second));
                        break;
                    default:
                        temp.push(String.valueOf(first / second));
                        break;
                }
            }
        }
        return Integer.parseInt(temp.pop());
    }
}
