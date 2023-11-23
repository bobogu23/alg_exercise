package com.alg.exercise.new20231009hot100;

/**
 * https://leetcode.cn/problems/first-missing-positive/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * <p>
 * 从1开始，看是否在数组nums中出现
 * 数组中每个位置i(从0开始)，对应位置上的数字应该是i+1。
 * 遍历数组，如果每个位置上的数字在 1~len范围内，那么num[i]=i+1,如果num[i] !=i+1,
 * 则交换到正确的位置。
 * <p>
 * 遍历完成后，再从头遍历，如果碰到num[i] !=i+1，则返回i+1
 *
 * @author ben.gu
 */
public class FirstMissingPositive_13 {
    public static void main(String[] args) {
        int[] a ={1,1};
        FirstMissingPositive_13 f = new FirstMissingPositive_13();
        System.err.println(f.firstMissingPositive(a));
    }

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] >= 1 && nums[i] <= len
                    && nums[i] != nums[nums[i]-1]) { //此处如果用 nums[i] != i+1,会死循环
                swap(nums, i, nums[i] - 1);//nums[i] 应该在位置 nums[i]-1 上,
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
