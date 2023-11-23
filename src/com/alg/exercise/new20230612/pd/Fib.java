package com.alg.exercise.new20230612.pd;

/**
 * https://leetcode.cn/problems/fibonacci-number/
 * <p>
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 */
public class Fib {

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int dp1 = 1, dp2 = 0;
        for (int i = 2; i <= n; i++) {
            int dpi = dp1 + dp2;
            dp2 = dp1;
            dp1 =dpi;
        }
        return dp1;
    }


}
