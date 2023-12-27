package com.alg.exercise.new20231215hot100.repeat;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * （下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标
 * ，否则返回 -1 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * @Author: gu
 * @Date: 2023/12/26 上午10:47
 */
public class SearchRotatedArray {

    public static void main(String[] args) {
        SearchRotatedArray s = new SearchRotatedArray();
        int[] a = new int[]{1,3};
        int res = s.search(a, 3);
        System.err.println(res);
    }

    //通过双指针找到 降序的第一个位置 p, 如果 target < nums[p],或者 target > nums[p-1]
    //则不存在这个目标值。
    //否则在 p 左右两个升序数组中查找 target
    public int search(int[] nums, int target) {
        int len = nums.length;

        int p = -1;
        for (int i = 0; i < len - 1; i++) {
            int n1 = nums[i];
            int n2 = nums[i + 1];
            if (n2 < n1) {
                p = i + 1;
                break;
            }
        }

        //数组只有一个元素
        if(nums.length == 1){
            return nums[0] == target ? 0:-1;
        }

        int low = 0;
        int high = len - 1;
        //在 nums[p...end] 查找
        if(p != -1){
            if (target < nums[0]) {
                low = p;
            } else {
                high = p - 1;
            }
        }


        while (low <= high) {
            int mid = high - (high - low) / 2;
            int n = nums[mid];
            if (n == target) {
                return mid;
            } else if (n < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

}
