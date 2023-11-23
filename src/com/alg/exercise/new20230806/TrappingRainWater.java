package com.alg.exercise.new20230806;

/**
 * https://leetcode.cn/problems/trapping-rain-water/
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 从局部思考，计算每个柱子能盛多少水。
 * 每个柱子i 能盛的水 = min [（0~i）最高的柱子的高度,(i~n-1)最高的柱子的高度] - i 柱子的高度
 * 使用备忘录，提前算好每个柱子i ，左右两边最高的柱子高度
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        TrappingRainWater t = new TrappingRainWater();
        System.err.println(t.trap(height));
    }

    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int len = height.length;
        int[] lmax = new int[len];
        int[] rmax = new int[len];
        lmax[0] = height[0];
        rmax[len - 1] = height[len - 1];

        //从左往右计算 每个柱子 左边的最大柱子高度
        for (int i = 1; i < len; i++) {
            lmax[i] = Math.max(lmax[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            rmax[i] = Math.max(height[i], rmax[i + 1]);
        }

        int res = 0;
        for (int j = 1; j < len - 1; j++) {
            res += Math.min(lmax[j], rmax[j]) - height[j];
        }
        return res;
    }


}
