package com.alg.exercise.easy.topcode20220829;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * * https://leetcode.cn/problems/longest-palindrome-by-concatenating-two-letter-words/?plan=leetcode_75&plan_progress=zci8d5e
 * 给你一个字符串数组 words 。words中每个元素都是一个包含 两个小写英文字母的单词。
 * <p>
 * 请你从 words 中选择一些元素并按 任意顺序 连接它们，并得到一个 尽可能长的回文串 。每个元素 至多 只能使用一次。
 * <p>
 * 请你返回你能得到的最长回文串的 长度 。如果没办法得到任何一个回文串，请你返回 0 。
 * <p>
 * 回文串 指的是从前往后和从后往前读一样的字符串。
 *
 * @return
 */
public class LongestPalindromeV2 {
    public static void main(String[] args) {
        String[] words = {"dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"};
        String[] word1 = {"ab",  "ba"};
        System.err.println(longestPalindrome(words));
        System.err.println(longestPalindrome1(word1));
    }


    public static int longestPalindrome1(String[] words) {
        //统计单词出现次数
        //遍历单词次数统计的map,如果单词中两个字母反转后跟原来的相同，偶数个可以构成对，回文长度4*单词对数
        //如果出现奇数个，最后回文长度+2
        //如果单词反转后不同，查询该反转后的单词出现次数，回文长度 = 两种单词出现次数的最小值*4
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            Integer count = map.getOrDefault(w, 0);
            map.put(w, ++count);
        }
        int count = 0;
        boolean mid = false;
        for (String key : map.keySet()) {
            String reverse = reverse(key);
            if (reverse.equals(key)) {
                count = count + map.get(key) / 2 * 4;
                if (map.get(key) % 2 == 1) {
                    mid = true;
                }
            } else if(map.containsKey(reverse)){
                //此处回文长度*2，为了遍历到对称的回文时还要计算长度。因为后面还能遍历到对称的回文串，还要计算回文串长度。
                //例如，words 【"ab","ba"】,第一次遍历到ab，发现存在对称的字符串 ba, 能组成回文串ab,ba。
                //第二次遍历到 ba,发现存在对称的字符串 ab,由于元素只能用一次，所以理论上要删除第一次遍历到的ab元素。
                //此处没有做删除操作，在计算回文长度上做了处理。

                count = count + Math.min(map.get(key), map.get(reverse)) * 2;

            }
        }
        if (mid) {
            count += 2;
        }
        return count;

    }

    public static String reverse(String word) {
        return new StringBuilder().append(word).reverse().toString();
    }

    //单词中如果两个字母相同，则回文串长度+2，且只能加一次
    //
    public static int longestPalindrome(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        if (words.length == 1) {
            if (words[0].charAt(0) == words[0].charAt(1)) {
                return 2;
            }
            return 0;
        }


        int len = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (palindrome(words[i], words[j])) {
                    words[i] = null;
                    words[j] = null;
                    len += 4;
                    break;
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            if (sameChar(words[i])) {
                len += 2;
                break;
            }
        }
        return len;
    }

    private static boolean sameChar(String word) {
        return word != null && word.charAt(0) == word.charAt(1);
    }

    private static boolean palindrome(String word, String word1) {
        return word != null && word1 != null
                && word.charAt(0) == word1.charAt(1) && word.charAt(1) == word1.charAt(0);
    }

}
