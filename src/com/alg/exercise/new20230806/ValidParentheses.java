package com.alg.exercise.new20230806;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-parentheses/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 *
 */
public class ValidParentheses {


    private Stack<Character> stack = new Stack<>();
    public boolean isValid(String s) {

        for(int i =0 ;i <s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else {
                if(!stack.isEmpty() && isMatch(c,stack.peek())){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatch(Character c,Character d){
        if(c == ')'){
            return d =='(';
        }
        if(c == '}'){
            return d =='{';
        }
        if(c == ']'){
            return d =='[';
        }
        return false;
    }

}
