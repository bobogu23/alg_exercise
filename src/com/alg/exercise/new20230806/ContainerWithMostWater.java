package com.alg.exercise.new20230806;

/**
 * https://leetcode.cn/problems/container-with-most-water/
 * <p>
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * <p>
 * ***双指针，指针从两端向中心收缩，一边收缩一边计算面积
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return  res;
    }

}
