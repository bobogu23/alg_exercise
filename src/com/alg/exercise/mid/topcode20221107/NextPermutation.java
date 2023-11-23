package com.alg.exercise.mid.topcode20221107;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/next-permutation/?favorite=2cktkvj
 *
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。
 * 更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列
 * 就是在这个有序容器中排在它后面的那个排列。
 * 如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 */
public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation p = new NextPermutation();
        int[] a = {1,1};
        p.nextPermutation(a);
        p.printArray(a);
    }

    private void printArray(int[] a) {
        StringBuilder sb = new StringBuilder("[");
        Arrays.stream(a).forEach(e -> sb.append(e).append(","));
        String s = sb.substring(0, sb.length() - 1) + "]";
        System.err.println(s);
    }


    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int i = nums.length - 2;
        int j = nums.length - 1;
        //找到第一个nums[i] < nums[j]
        for (; i >= 0 && nums[i] >= nums[j]; ) {
            i--;
            j--;
        }
        //此时 j -> end 是降序，从尾向前查找第一个满足nums[i] <nums[k],
        // 此时nums[i]就是较小数，nums[k]是较大数。交换nums[i]，nums[k]
        //j->end 改成升序
        if (i >= 0) {//nums不是降序的最后的一种排列
            int k = nums.length - 1;
            for (; nums[k] <= nums[i]; ) {
                k--;
            }
            //交换nums[i]，nums[k]
            swap(nums, i, k);
        }

        //翻转 j,end
        for (int end = nums.length - 1; j < end; ) {
            swap(nums, j, end);
            j++;
            end--;
        }

    }

    private void swap(int[] nums, int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }


}
