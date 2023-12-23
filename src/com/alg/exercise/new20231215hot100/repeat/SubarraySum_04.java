package com.alg.exercise.new20231215hot100.repeat;

import com.alg.exercise.new20230807hot100.SubarraySum;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/subarray-sum-equals-k/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 和为K的子数组.
 * <p>
 * 子数组是数组中元素的连续非空序列。
 *
 * @Author: gu
 * @Date: 2023/12/20 上午10:54
 */
public class SubarraySum_04 {
    public static void main(String[] args) {
        int[] a = {-1,-1,1};
        SubarraySum_04 s = new SubarraySum_04();
        int i = s.subarraySum(a, 1);
        System.err.println(i);

        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (a1,b) -> b-a1
        );
    }

    //滑动窗口
    public int subarraySum(int[] nums, int k) {
        int i = 0, j = 0;

        int sum = 0;
        int res = 0;
        int len = nums.length;
        for (; i < len ;i++) {
            //窗口中数组之和
            sum += nums[i];
            if (sum < k) {

                //子数组之和 <0,并且下一个数字<0,数组之和只会更小，缩小窗口
                if (i+1<len && nums[i+1] < 0){
                    sum -= nums[j];
                    j++;
                }
                continue;
            }
            if (sum == k) {
                res++;
            }
            //和 大于k，缩小窗口
            while (sum > k && j<i) {
                sum -= nums[j];
                if(sum == k){
                    res++;
                }
                j++;
            }
         }
        return res;
    }

}
