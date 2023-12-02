package com.alg.exercise.new20231009hot100.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/next-greater-element-i/
 * <p>
 * <p>
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * <p>
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * <p>
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * <p>
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 * <p>
 * <p>
 * 利用单调栈，求出nums2中每个元素的下一个更大的元素 数组 n，
 * 将n转成map，key：nums2中的每个元素v，value：v对应的下一个更大元素值
 * 遍历nums1，使用map取出对应的下一个更大的元素
 *
 * @author ben.gu
 */
public class NextGreaterElement_05 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] next = getNextGreaterEle(nums2);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], next[i]);
        }
        int[] res = new int[nums1.length];
        for (int j = 0; j < nums1.length; j++) {
            res[j] = map.get(nums1[j]);
        }
        return res;
    }

    private int[] getNextGreaterEle(int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int len = nums2.length;
        int[] res = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1:stack.peek();
            stack.push(nums2[i]);
        }
        return res;
    }
}
