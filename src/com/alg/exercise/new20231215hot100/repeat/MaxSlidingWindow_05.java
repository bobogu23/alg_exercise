package com.alg.exercise.new20231215hot100.repeat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: gu
 * @Date: 2023/12/22 下午10:18
 */
public class MaxSlidingWindow_05 {


    //单调栈
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonoticQueue win = new MonoticQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //前k-1个，填充窗口
            if (i < k - 1) {
                win.add(nums[i]);
            } else {
                //窗口滑动右边加入新数字
                win.add(nums[i]);
                res.add(win.getMax());
                //窗口滑动，移除最左边数字
                win.remove(nums[i - k + 1]);
            }
        }

        int[] arr = new int[res.size()];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = res.get(j);
        }
        return arr;

    }

    private class MonoticQueue {
        private LinkedList<Integer> queue = new LinkedList<>();

        public void add(Integer a) {
            while (!queue.isEmpty() && queue.getLast() < a) {
                queue.removeLast();
            }
            queue.add(a);
        }

        public Integer getMax() {
            return queue.getFirst();
        }

        public void remove(Integer a) {
            if (queue.getFirst().equals(a)) {
                queue.removeFirst();
            }
        }

    }


}
