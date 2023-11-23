package com.alg.exercise.new20230807hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/sliding-window-maximum/?envType=study-plan-v2&envId=top-100-liked
 * 滑动窗口最大值
 * <p>
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 * <p>
 * 使用单调队列，数字n入队列,将队列中小于n的数字删掉
 */
public class MaxSlidingWindow {


    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(i<k-1){
                window.push(nums[i]);
            }else {
                // 组装成长度为k的窗口
                window.push(nums[i]);
                int max = window.max();
                array.add(max);
                //移除窗口左边的数字，下轮循环往右移动.如果移除的数字是窗口中的最大数字，删除
                window.pop(nums[i-k+1]);
            }
        }
        int[] res = new int[array.size()];
        for(int j =0;j<res.length;j++){
            res[j] = array.get(j);
        }

        return res;

    }

    public static class MonotonicQueue {
        LinkedList<Integer> queue = new LinkedList<>();

        public void push(int n) {
            while (!queue.isEmpty() && queue.getLast() < n) {
                queue.removeLast();
            }
            queue.add(n);
        }

        //如果队首数字是 n，移除.也就是要移除的数据刚好是队列当前的最大值，则移除掉
        public void pop(int n) {
            if (queue.getFirst() == n) {
                queue.pollFirst();
            }
        }

        public int max() {
            return queue.getFirst();
        }
    }

}
