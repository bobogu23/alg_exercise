package com.alg.exercise.easy;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * 二分查找法，找到满足 mid^2 = x 的值
 */
public class Sqrt {
    public static void main(String[] args) {
        System.err.println(mySqrt(5));
    }

    public static int mySqrt(int x) {
        int low = 0;
        int high = x;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid <= x) {
                //mid ^2 不一定刚好 等于x,最接近x的也可以
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
