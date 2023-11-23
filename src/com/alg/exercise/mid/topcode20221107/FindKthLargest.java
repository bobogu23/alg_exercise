package com.alg.exercise.mid.topcode20221107;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 快速排序
 */
public class FindKthLargest {
    public static void main(String[] args) {
        FindKthLargest f = new FindKthLargest();
        System.err.println(f.findKthLargest(new int[]{2, 1}, 1));

    }

    public int findKthLargest(int[] nums, int k) {
        sort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public void sort(int[] nums, int i, int j) {
        //partition,排序好某个位置p的元素，
        int lo = i, high = j;
        if (lo >= high) {
            return;
        }
        int p = partition(nums, lo, high);
        //排序p之前，之后的数组
        sort(nums, lo, p - 1);
        sort(nums, p + 1, high);
    }

    private int partition(int[] nums, int lo, int high) {
        //选数组第一个元素p,比p小的排数组的左边，比p大的排数组的右边，
        int p = nums[lo];
        int i = lo + 1, j = high;
        while (i <= j) {
            while (i <= high && nums[i] <= p) {
                //跳出while循环时nums[i]>p
                i++;
            }
            while (j > lo && nums[j] > p) {
                //跳出while循环时nums[j]<p
                j--;
            }
            if (i >= j) {
                break;
            }
            //交换一下i,j位置上的元素，保证 小于p的在数组左边，大于p的在数组的右边
            swap(nums, i, j);
        }
        //由于p在数组第一个位置，现在需要把p放到j的位置，保证p左边的都小于p，p右边的都大于p
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int lo, int high) {
        int temp = nums[lo];
        nums[lo] = nums[high];
        nums[high] = temp;
    }
}
