package com.alg.exercise.new20230808hot100;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/next-greater-element-ii/
 * <p>
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ）
 * ，返回 nums 中每个元素的 下一个更大元素 。
 * <p>
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，
 * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 * <p>
 * 使用单调栈。
 * 循环数组，有两种方式查找数组末尾的下一个元素
 * 解法1），数组翻倍，
 * 解法2），数组长度计算翻倍，下标取余，做为原始数组的下标
 */
public class NextGreaterElement {

    public static void main(String[] args) {
        int[]nums1 = {1,2,3,4,3};

        NextGreaterElement n = new NextGreaterElement();
        int[] res = n.nextGreaterElements(nums1);
        CollectionPrintUtils.printArray(res);

    }

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 2 * len - 1; i >= 0; i--){
              int n = nums[i%len];
              //栈顶元素比当前元素小，剔除。此处for循环是倒着遍历，stack中的元素在当前遍历的元素后面，如果比当前元素小
             //则不会是前面元素的下一个更大元素
              while (!stack.isEmpty() && stack.peek() <= n){
                  stack.pop();
              }
            res[i%len] = stack.isEmpty() ? -1:stack.peek();
            stack.push(n);
        }
        return res;
    }
}
