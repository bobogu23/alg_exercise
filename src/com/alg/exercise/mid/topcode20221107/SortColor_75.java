package com.alg.exercise.mid.topcode20221107;

/**
 * https://leetcode.cn/problems/sort-colors/?favorite=2cktkvj
 *
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */
public class SortColor_75 {

    public static void main(String[] args) {
        SortColor_75 s = new SortColor_75();
        int[] arr = {2,0,2,1,1,0};
        s.sortColors(arr);
    }


    public void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int zero = 0;
        int two = nums.length;
        int i = 0;
        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                two--;
                swap(nums, i, two);
            }

        }


    }

    private void swap(int[] nums, int i, int zero) {
        int temp = nums[i];
        nums[i] = nums[zero];
        nums[zero] = temp;
    }


}
