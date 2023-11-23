package com.alg.exercise.easy;

import java.util.*;

public class ValidKuoHao {

    public static void main(String[] args) {
        String s = "{[]}";
        System.err.println(isValid(s));
        String s1 = "()[]{}";
        System.err.println(isValid(s1));
        String s2 = "()";
        System.err.println(isValid(s2));
        String s3 = "(]";
        System.err.println(isValid(s3));
        String s4 = "([)]";
        System.err.println(isValid(s4));
    }

    public static boolean isValid(String s) {
       if(s == null || s.length() <= 1){
           return false;
       }
        Map<String,String> map = new HashMap<>();
        map.put("(",")");
        map.put("[","]");
        map.put("{","}");
        map.put(")","(");
        map.put("]","[");
        map.put("}","{");

        Deque<String> stack = new LinkedList<>();
        for(int i =0; i<s.length(); i++){
            String el = s.charAt(i)+"";
            if(map.get(el) != null && map.get(el).equals(stack.peekFirst())){
                stack.pollFirst();
            }else {
                stack.offerFirst(el);
            }
        }
        return stack.size() == 0;
    }
}
