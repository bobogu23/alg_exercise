package com.alg.exercise.easy.topcode20220829;

/**
 * 盛水最多的容器
 * https://leetcode.cn/problems/container-with-most-water/
 */
public class ContainWater {
    public static void main(String[] args) {
        int[] array = {1,1};
        System.err.println(maxArea(array));
    }

    /**
     * 双指针 ，从左右两边往中间移动，高度小的一边往左或者往右移动，计算面积，取最大的面积
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            int dif = right - left;
            res = Math.max(dif * Math.min(height[left], height[right]), res);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
