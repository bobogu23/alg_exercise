package com.alg.exercise.new20231009hot100.stack;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/next-greater-element-ii/
 * <p>
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 * <p>
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1 。
 * <p>
 * 单调栈，循环数组，将原先的数组扩大一倍。
 * 或者遍历的长度扩大一倍，数组索引为 n%len
 *
 * @author ben.gu
 */
public class NextGreaterElement2_06 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        NextGreaterElement2_06 ng =new NextGreaterElement2_06();
        int[] res = ng.nextGreaterElements(nums);
        CollectionPrintUtils.printArray(res);

    }


    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % len]) {
                stack.pop();
            }
            res[i % len] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % len]);
        }
        return res;
    }


}
