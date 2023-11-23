package com.alg.exercise.new20230806labuladong;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/?envType=list&envId=9zwo3ww5
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * 使用栈
 */
public class ValidParentheses {


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (!stack.isEmpty()) {
                if(!isMatch(c,stack.peek())){
                    return false;
                }else {
                    stack.pop();
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatch(char c, Character peek) {
        if (c == ']') {
            return peek == '[';
        }
        if (c == '}') {
            return peek == '{';
        }
        if (c == ')') {
            return peek == '(';
        }
        return false;
    }
}
