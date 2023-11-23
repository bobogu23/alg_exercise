package com.alg.exercise.new20230422.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/move-zeroes/
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 快慢指针，slow=0,fast =0;
 * fast移动，
 * 判断元素 nums[fast]!=0, nums[slow]=nums[fast],slow++;
 * 判断元素 nums[fast] = 0,slow 不动。
 * 直到fast遍历结束，将slow及之后的元素设置成0.
 */
public class MoveZeroes_04 {

    public static void main(String[] args) {
       int[] array = {0};
        MoveZeroes_04 m = new MoveZeroes_04();
        m.moveZeroes(array);
        Arrays.stream(array).forEach(System.out::println);
    }


    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }

    }

}
