package com.alg.exercise.new20230422.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 * <p>
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，
 * 请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2]
 * ，则 1 <= index1 < index2 <= numbers.length 。
 * <p>
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * <p>
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * <p>
 * 左右指针，从两端相向而行，
 * 如果 两个指针对应的元素值之和> target则，右指针往左移动。
 * 如果两个指针对应的元素值之和< target则，左指针往右移动。
 */
public class TwoSum_01 {
    public static void main(String[] args) {
        int[] numbers = {-1,0};
        TwoSum_01 t = new TwoSum_01();
        int[] results = t.twoSum(numbers, -1);
        Arrays.stream(results).forEach(System.out::println);

    }


    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            }else {
                return new int[]{left+1,right+1};
            }
        }

        return new int[]{};
    }


}
