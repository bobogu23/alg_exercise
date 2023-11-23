package com.alg.exercise.mid.topcode20221107;

import java.net.CacheRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * <p>
 * 双指针 pre,cur，cur往前移，遇到重复的字符，pre移动到cur，清空set，记录子串长度，cur继续移动
 * 0,1,2  2-0=2
 */

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "dvdf";
        //abcabcbb,pwwkew,bbbbb,dvdf
        System.err.println(lengthOfLongestSubstring(s));
        System.err.println(longest(s));
    }

    public static int longest(String source){
        int pre = 0,cur=0;
        int len =0;
        Set<Character> substrs = new HashSet<>();
        for (;cur < source.length();cur++){
            Character c = source.charAt(cur);
            if(substrs.contains(c)){
                len = Math.max(cur-pre,len);
                //pre移动到重复元素的位置
                for(;pre< cur;pre++){
                    if(c.equals(source.charAt(pre))){
                        pre++;
                        break;
                    }
                }
                //清除substrs,重新导入不重复的数据
                substrs.clear();
                for(int i = pre; i<cur;i++){
                    substrs.add(source.charAt(i));
                }
            }
            substrs.add(c);
        }
        return Math.max(substrs.size(),len);
    }

    public static int lengthOfLongestSubstring(String s) {
        int pre = 0, cur = 0;
        int longestLength = 0;
        Set<Character> subStrs = new HashSet<>();
        for (; cur < s.length(); cur++) {
            Character c = s.charAt(cur);
            //判断是否碰到重复字符
            if (subStrs.contains(c)) {
                longestLength = Math.max(cur - pre, longestLength);
                for (; pre < cur; pre++) {
                    //找到出现重复元素的位置，往后移一位
                    if (c.equals(s.charAt(pre))) {
                        pre++;
                        break;
                    }
                }
                subStrs.clear();//清空不重复子串中的字符
                for (int i = pre; i <cur; i++) {
                    //加入新的子串中的字符
                    subStrs.add(s.charAt(i));
                }
            }
            subStrs.add(c);
        }
        return Math.max(subStrs.size(), longestLength);
    }
}
