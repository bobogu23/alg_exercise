package com.alg.exercise.mid.topcode20221107;

public class JumpGame_55 {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int fartest = 0;
        for (int i = 0; i < n - 1; i++) {
            fartest = Math.max(nums[i] + i, fartest);
            //如果原地不动，结束
            if (fartest <= i) {
                return false;
            }
        }
        return fartest >= n - 1;

    }


}
