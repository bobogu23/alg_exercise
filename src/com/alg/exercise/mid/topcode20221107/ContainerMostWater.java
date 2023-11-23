package com.alg.exercise.mid.topcode20221107;

/**
 * https://leetcode.cn/problems/container-with-most-water/?favorite=2cktkvj
 * <p>
 * 盛水最多的容器
 * 2个指针，从两头往数组中间移动，往高度高的方向移动
 */
public class ContainerMostWater {
    public static void main(String[] args) {
        int[] h = {1, 1};
        System.err.println(maxArea(h));
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max,area);
            if(height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }

}
