package com.alg.exercise.new20231009hot100.skil;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/next-permutation/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * <p>
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * <p>
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大
 * 排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，
 * 那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *  * <p>
 *  * 必须 原地 修改，只允许使用额外常数空间。
 *
 * <p>
 * [1,3,2] 预期结果： [2,1,3]
 *
 *  从尾部向头部遍历数组，找到出现升序的位置。
 *  3,2 降序， 1，3 升序。
 *
 *  遍历 到 1，3 终止。
 *  从尾部开始遍历，找到 大于 1 的数字。这里是2，交换 1，2，
 *  现在数组中数字为  2,3,1。 从3开始做升序排序。最终 数组中数字 ： 2，1，3
 *
 *  为什么从尾部开始寻找第一个 大于 1 的数字，尾部开始的数字较小，与1交换位置后，再排序就是下一个字典更大
 *  的排列。
 *
 *
 *
 *
 * <p>
 * <p>
 *
 *
 * @Author: gu
 * @Date: 2023/12/15 下午1:22
 */
public class NextPermutation_04 {

    public static void main(String[] args) {
        NextPermutation_04 np = new NextPermutation_04();
        int[] a = {1,1,5};
        np.nextPermutation(a);
        CollectionPrintUtils.printArray(a);
    }


    // 1 ,5 , 3 , 2 -> 2,5,3,1 -> 2,1,3,5
    // 4, 5, 3, 2 -> 5,  4,  3,  2 -> 5,   2, 3,4
    // i, j       -> i,(j,k)      ->  i,   j
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        int j = n-1;
        //从尾部开始遍历,找到升序的位置
        for(;i>=0;i--,j--){
            if(nums[i] < nums[j]){
                break;
            }
        }
        //不是完全降序
        if(i>=0){
            //找到 j ~ end 范围内，大于 i位置的数字
            int k = n-1;
            while (k >= 0 && nums[k] <= nums[i]){
                k--;
            }
            //交换i,k
            swap(nums,k,i);
        }
        //从j开始排序数组
        Arrays.sort(nums,j,n);

    }

    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] =  tmp;
    }


}
