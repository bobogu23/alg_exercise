package com.alg.exercise.new20231009hot100.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/decode-string/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："acc acc acc"
 * <p>
 * 思路：
 * 搞一个 存放表示次数的数字 的栈 s1，
 * 搞一个 存放 出现[ 之前的字符的栈 s2,
 * 遇到]时，pop出重复数字n,  s2.pop +  n * [xxx] ,xxx 是 [,]之间的字符。
 * <p>
 * 用一个 stringbuilder 保存每次执行重复字符串后的结果
 *
 * @author ben.gu
 */
public class DecodeString_03 {

    public static void main(String[] args) {
        DecodeString_03 ds = new DecodeString_03();
        String s = ds.decodeString("2[abc]3[cd]ef");
//        String s = ds.decodeString("3[a]2[bc]");
//        String s = ds.decodeString("abc3[cd]xyz");
//        String s = ds.decodeString("3[a2[c]]");
        System.err.println(s);

    }


    public String decodeString(String s) {
        LinkedList<String> stackRes = new LinkedList<>();
        LinkedList<Integer> stackMulti = new LinkedList<>();
        int multi = 0;
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                // 重复次数可能是多位整数
                multi = multi * 10 + Integer.parseInt(c + "");
            } else if (c == '[') {
                // [ 之前的字符串，数字 入栈
                stackRes.addLast(res.toString());
                stackMulti.addLast(multi);
                //重新初始化
                multi = 0;
                res = new StringBuilder();
            }else if(c==']'){
                //重复 字符串 res
                Integer n = stackMulti.removeLast();
                StringBuilder tmp = new StringBuilder();
                for(int i =0;i<n;i++){
                    tmp.append(res.toString());
                }
                //取出 stackRes中的字符串，加到 重复字符串的前面
                res = new StringBuilder(stackRes.removeLast()+tmp.toString());
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }

}
