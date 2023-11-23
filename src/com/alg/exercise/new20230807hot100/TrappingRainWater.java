package com.alg.exercise.new20230807hot100;

/**
 * 接雨水
 * <p>
 * 计算每个柱子左右两边最高的柱子
 * 可盛放的雨水 = min（l_max,r_max）-height
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int[] lmax = new int[height.length];
        int[] rmax = new int[height.length];
        lmax[0] = height[0];
        rmax[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            lmax[i] = Math.max(lmax[i - 1], height[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], height[i]);
        }

        int res = 0;
        for (int j = 1; j < height.length - 1; j++) {
            res = res+ Math.min(lmax[j],rmax[j])-height[j];
        }
        return res;
    }
}
