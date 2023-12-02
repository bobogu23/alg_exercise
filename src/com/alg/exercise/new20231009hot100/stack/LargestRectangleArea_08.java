package com.alg.exercise.new20231009hot100.stack;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/solutions/142012/bao-li-jie-fa-zhan-by-liweiwei1419/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 解题：
 * 遍历每个柱子，柱子高度增加 则加入到栈 stack 中，不计算面积。遇到比stack中柱子低的柱子，才开始计算stack中
 * 高的柱子组成的矩形的面积。
 * stack 中pop出一个柱子下标 n，
 * 计算面积时，需要往左寻找第一个比 柱子n高度低的柱子 l ，计算出矩形的宽度，curindex -l -1
 * <p>
 * 左右两边加上哨兵节点，不用考虑边界问题
 *
 * @author ben.gu
 */
public class LargestRectangleArea_08 {

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }

        int len = heights.length;
        int[] newHeights = new int[len + 2];
        newHeights[0] = -1;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = -1;
        int newLen = len + 2;

        int res = 0;
        //存放柱子的索引
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < newLen; i++) {
            int h = newHeights[i];
            //stack 不可能为空，最底下有个哨兵柱子
            while (newHeights[stack.peek()] > h) {
                Integer hi = newHeights[stack.pop()];
                //找到第一个比 hi小的柱子的索引,就在hi的左边
                res = Math.max(res, hi * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return res;
    }

}
