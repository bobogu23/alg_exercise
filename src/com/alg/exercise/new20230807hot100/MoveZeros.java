package com.alg.exercise.new20230807hot100;

/**
 * https://leetcode.cn/problems/move-zeroes/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 快慢指针，slow,fast,不等于 target值的元素往slow位置上移动，最后slow ~ 数组末尾 填0
 */
public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int slow =0,fast =0;
        for(int i =0 ;i < nums.length;i++){
            if(nums[fast] != 0){
              nums[slow] =nums[fast];
              slow++;
            }
            fast++;
        }
        for(;slow<nums.length;slow++){
            nums[slow] = 0;
        }

    }
}
