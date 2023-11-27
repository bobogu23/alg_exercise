package com.alg.exercise.new20231009hot100.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-parentheses/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * 思路：
 * 将字符串转成字符数组
 * 使用栈，将字符数组入栈，左括号入栈，碰到右括号，出栈一个左括号，如果最后栈为空，则返回true
 *
 * @author ben.gu
 */
public class Valid_Parentheses_01 {


    public static void main(String[] args) {
        String s ="(]";
        Valid_Parentheses_01 v = new Valid_Parentheses_01();
        boolean res = v.isValid(s);
        System.err.println(res);
    }


    private List<Character> l = new ArrayList<>();
    private List<Character> r = new ArrayList<>();
    private Map<Character,Character> map = new HashMap<>();

    public boolean isValid(String s) {
        if(s==null || s.length()==1){
            return false;
        }
        char[] chars = s.toCharArray();

        l.add('(');
        l.add('[');
        l.add('{');

        r.add(')');
        r.add('}');
        r.add(']');

        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> stack = new Stack<>();
        for(char c: chars){
            //碰到右括号，但是没有左括号匹配
            if(r.contains(c) &&(stack.isEmpty()) ){
                return false;
            }
            if(r.contains(c) && stack.peek() != map.get(c)){
                return false;
            }
            if(r.contains(c) && stack.peek()== map.get(c)){
                stack.pop();
                continue;
            }
            //碰到左括号，入栈
            if(l.contains(c)){
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

}
