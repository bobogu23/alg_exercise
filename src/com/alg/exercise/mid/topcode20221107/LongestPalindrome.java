package com.alg.exercise.mid.topcode20221107;

/**
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome p = new LongestPalindrome();
        String s = "cbbd";
        System.err.println(p.longestPalindrome(s));

    }

    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        //寻找以 i 为中心，向两边扩散的最长回文子串，
        //寻找以 i+1，i 为中心，向两边扩散的最长回文子串，
        //i从0~ s.length-1
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = longestPalindrome(s, i, i);
            String s2 = longestPalindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public String longestPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return s.substring(i + 1, j);
    }


}
