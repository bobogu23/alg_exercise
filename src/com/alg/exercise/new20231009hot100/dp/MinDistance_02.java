package com.alg.exercise.new20231009hot100.dp;

import com.alg.exercise.new20230811dp.MinDistance;

import java.util.Arrays;

/**
 * 最少操作数。
 * <p>
 * 编辑距离问题就是给我们两个字符串s1和s2，只能用三种操作，让我们把s1变成s2，求最少的操作数。
 * <p>
 * 解题：
 * <p>
 * 假设当前在s1,s2中操作的字符 分别为s1[i],s2[j]。
 * i,j 分别指向s1,s2的最后，一步步往前走
 * <p>
 * 操作分为几种情况
 * 1、s[i],s[j] 相同 ，则不用操作，i,j 往前移
 * 2、s[i] 删除，i往前移动，j不动
 * 3、s1中插入字符，i不动，j往前移
 * 4、s[i]替换成s[j],i,j往前移动
 * <p>
 * int dp(i,j) 表示 s1[0~i],s2[0~j]的最小编辑距离
 * <p>
 * 备忘录消除重复的操作
 *
 * @Author: gu
 * @Date: 2023/12/11 下午6:08
 */
public class MinDistance_02 {
    public static void main(String[] args) {
        MinDistance_02 m = new MinDistance_02();
        String s1 = "intention";
        String s2 = "execution";
        int res = m.minDistance(s1,s2);
        System.err.println(res);

    }


    private int[][] memo;

    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i],-1);
        }
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        int res = dp(m - 1, n - 1, a1, a2);
        return res;
    }

    private int dp(int i, int j, char[] s1, char[] s2) {

        //base case.字符串s1遍历完了
        if (i == -1) {
            return j + 1;
        }
        //字符串s2遍历完了
        if (j == -1) {
            return i + 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        //字符一致，往前移动
        if (s1[i] == s2[j]) {
            memo[i][j] = dp(i - 1, j - 1, s1, s2);
        } else {
            memo[i][j] = min(
                    dp(i - 1, j, s1, s2) + 1,//删除
                    dp(i, j - 1, s1, s2) + 1,//插入
                    dp(i - 1, j - 1, s1, s2) + 1//插入
            );
        }
        return memo[i][j];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }


}
