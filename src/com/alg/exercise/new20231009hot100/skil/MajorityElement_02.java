package com.alg.exercise.new20231009hot100.skil;

/**
 * https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *解法：
 * 想象正负电子，假设多数元素是正电子，正负电子混在一起，由于正电子多，正负电子相消之后，最终剩下的是正电子。
 *
 * @Author: gu
 * @Date: 2023/12/15 下午12:25
 */
public class MajorityElement_02 {

    public int majorityElement(int[] nums) {
        int count =0;
        int target = 0;

        for(int n:nums){
            if(count == 0 ){ //正负电子相消了，或者刚变量数组。就把当前数字多数元素。
                target = n;
                count =1;
            }else if(n == target){
                count++;
            }else {
                count--;
            }
        }
        return target;

    }
}
