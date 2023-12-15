package com.alg.exercise.new20231009hot100.skil;

/**
 * https://leetcode.cn/problems/single-number/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 * 解法：
 * 一个数字跟它本身异或 =0，一个数字跟0异或 = 它本身。
 * 遍历数组，开始与0异或，最后得到的结果 就是出现一次的数字.
 *
 * 解法：
 *
 *
 * @Author: gu
 * @Date: 2023/12/15 上午9:28
 */
public class SingleNumber_01 {

    public int singleNumber(int[] nums) {
        int res  =0;
        for(int i =0;i<nums.length;i++){
            res  =  res ^ nums[i];
        }
        return res;

    }

}
