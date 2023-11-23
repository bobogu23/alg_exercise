package com.alg.exercise.easy.topcode20220829;

/**
 * 接雨水
 * https://leetcode.cn/problems/trapping-rain-water/
 */
public class TrapWater {

    /**
     * 每个柱子能盛的水=左右最高柱子的高度最小值-当前柱子的高度
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;

        }
        //先计算一遍每个柱子的左右最高的柱子
        int length = height.length;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        leftMax[0]=height[0];
        rightMax[length-1]=height[length-1];
        int res = 0;
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        //遍历每个柱子，计算盛水量
        for (int i = 1; i < length - 1; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }
}
