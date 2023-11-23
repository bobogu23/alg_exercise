package com.alg.exercise.new20231009hot100;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.LinkedList;

/**
 * 滑动窗口最大值
 * https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 * <p>
 * 单调栈。 使用滑动窗口遍历数组时，维护一个 单调递减的元素的队列，队首元素是窗口内的最大值，队尾元素是窗口内的
 * 最小值。
 * <p>
 * 窗口移动时：
 * 1、不断的往队列尾部添加元素，并且保证队尾元素比当前要加入的元素大，否则删除队尾元素。
 * 2、从队列中移除不在窗口内的元素，即判断队首元素是不是已经不在窗口中，如果不在 则移除队首元素。
 * <p>
 * 要判断队首元素是否已经不在窗口中，则 记录 元数的索引。
 *
 * @author ben.gu
 */
public class SlidingWindowMaximum_10 {
    public static void main(String[] args) {
        int[] nums = {1};
        SlidingWindowMaximum_10 m = new SlidingWindowMaximum_10();
        CollectionPrintUtils.printArray(m.maxSlidingWindow(nums,1));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();//存储元素的索引.
        int[] max = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.add(i);
            //判断队首元素是否已经不在窗口中,窗口左边界 l = i-k+1
            if (queue.peek() < i - k + 1) {
                queue.poll();
            }

            //记录窗口内的最大值
            if(i - k + 1 >= 0){
                max[i - k + 1] = nums[queue.peek()];
            }
        }
        return  max;
    }
}
