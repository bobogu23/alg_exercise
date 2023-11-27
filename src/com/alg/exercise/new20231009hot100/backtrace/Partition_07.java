package com.alg.exercise.new20231009hot100.backtrace;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/palindrome-partitioning/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 相关企业
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * <p>
 * 从 s 的头部开始暴力穷举，如果发现 s[0..i] 是一个回文子串，那么我们就可以把 s 切分为 s[0..i] 和 s[i+1..]，
 * 然后我们去尝试把 s[i+1..] 去暴力切分成多个回文子串即可。
 * <p>
 * PS: 至于如何判断一个字符串是否是回文串，我在 数组双指针技巧汇总 中的左右指针部分有讲解，很简单。
 * <p>
 * 把这个思路抽象成回溯树，树枝上是每次从头部穷举切分出的子串，节点上是待切分的剩余字符串：
 *       aab
 *    /  |  \
 *   a   aa    aab
 * / |    |
 *a  ab   b
 *
 * @author ben.gu
 */
public class Partition_07 {
    public static void main(String[] args) {
        Partition_07 p = new Partition_07();
        String s = "aab";
        List<List<String>> lists = p.partition(s);
        CollectionPrintUtils.printList(lists);

    }


    private List<List<String>> res = new ArrayList<>();
    private LinkedList<String> tmp = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtrace(s, 0);
        return res;
    }

    private void backtrace(String s, int index) {
        //index 能走完，说明子串都是回文
        if (index >= s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            //从index开始寻找回文
            String sub = s.substring(index, i+1);
            if (!isHuiwen(sub)) {
                continue;
            }
            // start ~ i 是回文，可以继续分割
            tmp.add(sub);
            //继续分割s[i+1...]
            backtrace(s, i + 1);
            tmp.removeLast();
        }
    }


    private boolean isHuiwen(String str) {
        if(str.isEmpty()){
            return false;
        }
        int len = str.length();
        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
