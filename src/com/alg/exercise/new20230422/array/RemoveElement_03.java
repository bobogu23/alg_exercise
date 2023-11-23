package com.alg.exercise.new20230422.array;

/**
 * https://leetcode.cn/problems/remove-element/
 * <p>
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * <p>
 * 从0开始遍历数组，下标=i，发现等于目标值的数值val，从数组尾部开始寻找数值！=val的数值，下标j，交换i,j的元素值。
 */
public class RemoveElement_03 {

    public static void main(String[] args) {
        int[] array = {0,1,2,2,3,0,4,2};
        RemoveElement_03 r = new RemoveElement_03();
        int result = r.removeElement(array, 2);
        System.err.println(result);

    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] != val) {
                        switchEle(nums, i, j);
                        break;
                    }
                }
                if (nums[i] == val) {
                    break;
                }
            }
        }
        return i;
    }

    private void switchEle(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
