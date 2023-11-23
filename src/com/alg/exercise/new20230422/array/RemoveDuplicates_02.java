package com.alg.exercise.new20230422.array;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 * <p>
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 * <p>
 * 使用快慢指针，快指针在慢指针前面探路，每移动一次判断所指元素值是否与慢指针所指元素值一致。
 * if(nums[fast] != nums[slow]) ,slow 移动一位，并且将nums[slow]=nums[fast]。
 * if(nums[fast] == nums[slow]) ,slow不动。
 */
public class RemoveDuplicates_02 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        RemoveDuplicates_02 r = new RemoveDuplicates_02();
        int len = r.removeDuplicates(nums);
        System.err.println(len);

    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }

        return slow + 1;

    }


}
