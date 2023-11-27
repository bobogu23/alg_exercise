package com.alg.exercise.new20231009hot100.binarysearch;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * <p>
 * 将数组一分为二，其中一定有一部分是有序的，另一部分无序。
 * 如何判断[l,r] 有序？  nums[l] <= nums[r]。
 * <p>
 * 查找target 就在有序的部分查找，如果 target 不在 有序区间内[l,r],则 拆分无序区间，
 * 拆成有序，无序部分，继续在有序部分查找。
 *
 * @author ben.gu
 */
public class SearchRotate_04 {

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            }
            return -1;
        }
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //l->mid 区间有序
            if (nums[l] <= nums[mid]) {
                //在区间内
                if (target < nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    //不在区间内
                    l = mid + 1;
                }
            } else {
                //mid-> r 区间有序
                if (nums[mid] < target && target <= nums[r]) {
                    //在区间内
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }


}
