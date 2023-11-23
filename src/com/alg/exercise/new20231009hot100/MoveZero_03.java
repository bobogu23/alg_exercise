package com.alg.exercise.new20231009hot100;

import com.alg.exercise.utils.CollectionPrintUtils;

import javax.swing.plaf.SliderUI;

/**
 * https://leetcode.cn/problems/move-zeroes/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 双指针，
 * 一个指针遍历数组中每个元素
 * 一个指针记录最后一个非零元素的位置
 *
 * @author ben.gu
 */
public class MoveZero_03 {

    public static void main(String[] args) {
        MoveZero_03 m = new MoveZero_03();
        int[] nums = {0,1,0,3,12};
        m.moveZeroes(nums);
        CollectionPrintUtils.printArray(nums);

    }


    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int l1 = 0;
        int l2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[l2] != 0) {
                nums[l1] = nums[l2];
                l1++;
            }
            l2++;
        }
        //非0元素都左移到数组左边后，剩余位置填0
        for (; l1 < nums.length; l1++) {
            nums[l1] = 0;
        }
    }


}
