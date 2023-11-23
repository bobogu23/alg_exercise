package com.alg.exercise.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {
        // 定义正则表达式
        String regex = "\\[[0-9]{1,2}\\-[0-9]{1,2}\\]"; // 匹配字母和数字

        // 要验证的字符串
//        String input = "[00-99]";
        String input = "[1-99]";

        // 创建 Pattern 对象
        Pattern pattern = Pattern.compile(regex);

        // 创建 Matcher 对象
        Matcher matcher = pattern.matcher(input);

        // 进行匹配
        if (matcher.matches()) {
            System.out.println("符合");
        } else {
            System.out.println("不符合");
        }
        System.err.println("index of '-':"+input.indexOf("-"));
        System.err.println("end:"+input.substring(3,input.length()-1));
        System.err.println("num:"+Integer.valueOf("00"));
    }
}
