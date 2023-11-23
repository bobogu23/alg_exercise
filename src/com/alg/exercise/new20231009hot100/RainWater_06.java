package com.alg.exercise.new20231009hot100;

/**
 * https://leetcode.cn/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-100-liked
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 计算每个柱子左边，右边的最高的柱子。
 * 接雨水数量= min(左边最高柱子，右边最高柱子) - 当前柱子高度
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下
 * ，可以接 6 个单位的雨水（蓝色部分表示雨水）
 *
 * @author ben.gu
 */
public class RainWater_06 {
    public static void main(String[] args) {
        RainWater_06 r = new RainWater_06();
        int[] array = {4,2,0,3,2,5};
        System.err.println(r.trap(array));
    }


    public int trap(int[] height) {
        int len = height.length;
        int[] lmax = new int[len];
        int[] rmax = new int[len];
        lmax[0] = height[0];
        rmax[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            lmax[i] = Math.max(lmax[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], height[i]);
        }
        int res = 0;
        for (int j = 0; j < len; j++) {
            res = Math.min(lmax[j], rmax[j]) - height[j] + res;
        }
        return res;
    }


}
