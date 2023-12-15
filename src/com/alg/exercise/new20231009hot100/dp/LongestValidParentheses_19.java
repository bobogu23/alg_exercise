package com.alg.exercise.new20231009hot100.dp;

import java.util.Stack;

/**
 * 最长有效括号子字符串。
 *
 * https://leetcode.cn/problems/longest-valid-parentheses/solutions/922407/zhan-zui-jian-jie-yi-dong-de-dai-ma-cjav-xa7v/?envType=study-plan-v2&envId=top-100-liked
 *
 * 子串是连续的。
 *
 * 定义变量start ，记录最长有效括号子串的起始位置。
 * 使用栈，存储 左括号。
 *
 * 如果遇到 右括号。位置i
 *
 * 1） 如果栈为空，当前start开始的子串不再可能是最长有效子串了，下一个合法的子串的起始位置可能是 i+1
 * 2） 如果栈不为空，弹出栈。
 *     弹栈后，如果栈为空，则说明当前右括号为右端点的合法子串的起始位置为start, 更新最大长度max = i-start+1
 *     弹栈后，如果栈不为空，说明还有左括号，则当前右括号为右端点的合法子串的长度 i- stack.peek;
 *     示例： ( ( )
 *
 *
 * @Author: gu
 * @Date: 2023/12/14 下午12:42
 */
public class LongestValidParentheses_19 {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int start  = 0;
        int max = 0;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) =='('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    start = i+1;
                }else {
                    stack.pop();
                    if(stack.isEmpty()){
                        max = Math.max(max,i-start+1);
                    }else {
                        max = Math.max(max,i-stack.peek());
                    }
                }

            }
        }

        return max;

    }

}
