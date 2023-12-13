package com.alg.exercise.new20231009hot100.greed;

/**
 * https://leetcode.cn/problems/jump-game/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 解法：
 * 贪心算法 计算每个位置上能达到的最远距离。
 *
 * @Author: gu
 * @Date: 2023/12/9 下午4:05
 */
public class CanJump_02 {


    public boolean canJump(int[] nums) {
        int len = nums.length;
        int farthest = 0;
        // 只需遍历到len-2, 如果到了len-1，说明已经到了最后一个下标。
        for (int i = 0; i < len - 1; i++) {
            int far = i+nums[i];//当前位置+跳跃距离
            farthest = Math.max(farthest,far);
            if(far <= i){ //没有前进
                return false;
            }

        }
        return  farthest >= len -1;

    }

}
