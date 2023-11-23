package com.alg.exercise.mid.topcode20221107;

/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/?favorite=2cktkvj
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * 有序数组，二分查找
 * 先找到发生旋转的位置 m ，判断target 在m左边还是右边，在左右两边进行二分查找
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] array = {1,3};
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        System.err.println(s.search(array,3));

    }

    public int search(int[] nums, int target) {
        int split = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                split = i;
                break;
            }
        }
        if(split ==-1){
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        //split 是数组旋转的分界点，也是左半部分有序数组的最后一个元素

        if (target == nums[split]) {
            return split;
        }


        if (nums[0] > target) {
            //在右半部分二分查找
            return binarySearch(nums, target, split + 1, nums.length - 1);
        } else {
            return binarySearch(nums, target, 0, split - 1);
        }

    }

    private int binarySearch(int[] nums, int target, int start, int end) {

        int low = start, high = end;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
