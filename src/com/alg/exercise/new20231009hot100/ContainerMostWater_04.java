package com.alg.exercise.new20231009hot100;

/**
 * https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 *
 * @author ben.gu
 */
public class ContainerMostWater_04 {
    public static void main(String[] args) {
        int [] array ={1,1};
        ContainerMostWater_04 c = new ContainerMostWater_04();
        System.err.println(c.maxArea(array));
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;

        while (left < right) {
            int hl = height[left];
            int hr = height[right];
            res = Math.max(res, (right - left) * Math.min(hl, hr));
            //左边垂线低，往右移动
            if (hl < hr) {
                left++;
            } else {
                right--;
            }
        }
        return res;

    }
}
