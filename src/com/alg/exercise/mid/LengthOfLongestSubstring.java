package com.alg.exercise.mid;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 从左往右遍历字符串,两个指针。第一个指针不断往右边遍历字符,用set保存已经遍历的字符, 如果碰到重复的,
 * 第二个指针往右移动一位,并且删除set中当前指针对应的元素
 */
public class LengthOfLongestSubstring {


    public int lengthOfLongestSubstring(String s) {
        //往右遍历的指针,
        int right = -1;
        int maxLength = 0;
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            //i!=0 说明,出现重复元素了,需要往右移动,一直到剔除重复元素
            if (i != 0) {
                characterSet.remove(s.charAt(i));
            }
            //一直往右遍历,知道碰到重复的元素
            while (right + 1 < s.length() && !characterSet.contains(s.charAt(i))) {
                characterSet.add(s.charAt(i));
                right++;
            }
            //右指针，跟左指针之间的距离,就是最长子串的长度
            maxLength = Math.max(maxLength, right - i + 1);
        }
        return maxLength;
    }

    // abca, pre=1
    public int lengthOfLongestSubstring1(String s) {
        int pre = 0, cur = 0;
        int longestLength = 0;
        Set<Character> subStrs = new HashSet<>();
        for (; cur < s.length(); cur++) {
            Character c = s.charAt(cur);//遍历字符串中的每个字符
            if (subStrs.contains(c)) {//如果重复的字符
                //计算连续子串的长度
                longestLength = Math.max(cur - pre, longestLength);
                for (; pre < cur; pre++) { //计算下一个子串的起始位置
                    if (c.equals(s.charAt(pre))) {//找到了出现重复字符的位置，
                        //例如: pww, 第二个w 出现了重复，找到第一个出现的w，下一个位置即为下一个子串的起始位置
                        pre++;//下一个子串的起始位置 = 重复字符的下一个位置
                        break;
                    }
                }
                subStrs.clear();// 清空set，重新加入不重复的字符
                for (int i = pre; i <cur; i++) {
                    subStrs.add(s.charAt(i));
                }
            }
            subStrs.add(c);//没遇到重复的字符，加入到set
        }
        return Math.max(subStrs.size(), longestLength);

    }
}
