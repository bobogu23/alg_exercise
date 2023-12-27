package com.alg.exercise.new20231215hot100.repeat;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * @Author: gu
 * @Date: 2023/12/26 下午12:11
 */
public class ValidParentheses {


    //遇到 左括号 入栈，遇到右括号，弹栈拿出左括号，如果没有匹配的左括号 返回false
    public boolean isValid(String s) {
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c :arr){
            if(map.containsKey(c)){
                stack.push(c);
            }else {
                //碰到右括号了
                if(stack.isEmpty() || !isMatch(stack.peek(),c)){
                     return false;
                }else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    private Map<Character,Character> map = new HashMap<>();

    private boolean isMatch(char left,char right){

        return map.get(left) == right;
    }

}
