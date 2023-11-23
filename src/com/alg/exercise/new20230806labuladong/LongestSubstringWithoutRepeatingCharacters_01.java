package com.alg.exercise.new20230806labuladong;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=list&envId=9zwo3ww5
 * <p>
 * 最长子串
 * 滑动窗口
 * 窗口往右扩大，什么时候缩小窗口？
 */
public class LongestSubstringWithoutRepeatingCharacters_01 {
    public static void main(String[] args) {
        String s = " ";
        LongestSubstringWithoutRepeatingCharacters_01 l =new LongestSubstringWithoutRepeatingCharacters_01();
        System.err.println(l.lengthOfLongestSubstring(s));
    }


    int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (count.get(c) == null) {
                count.put(c, 1);
            } else {
                res = Math.max(res, right - left);
                while (left < right) {
                    char l = s.charAt(left);
                    count.remove(l);
                    left++;
                    if (l == c) {
                        //碰到重复字符，前面已经删掉，此处还原
                        count.put(l,1);
                        break;
                    }
                }
            }
            right++;
        }
        return Math.max(count.size(),res);

    }
}
